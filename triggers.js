// UpdateGameAndUserOnReviewInsert
exports = async function(changeEvent) {
    const insertedReview = changeEvent.fullDocument;
    const gameIdObj = BSON.ObjectId(insertedReview.gameID);
    const author = insertedReview.author;
    
    const gamesCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("games");
    const game = await gamesCollection.findOne({_id: gameIdObj});
    
    const reviewsCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("reviews");
    const reviews = await reviewsCollection.find({gameID: insertedReview.gameID}).toArray();
    
    const usersCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("users");
    const user = await usersCollection.findOne({nickname: author});
    
    // if user has already reviewed the game - delete the duplicate
    if (user.reviews.length > 0){
        if (user.reviews.some(review => String(review.gameID) === String(gameIdObj))) {
            console.log("User has already reviewed the game.");
            await reviewsCollection.deleteOne({_id: insertedReview._id})
            return;
        }
    }
  
    
    const userReviews = user.reviews;
    userReviews.push(insertedReview)
    
    if (reviews.length > 0) {
  
        let totalRating = 0;
        for (const review of reviews) {
        totalRating += review.carrotRate;
        }
        const averageRating = totalRating / reviews.length;
      
        await gamesCollection.updateOne(
            { _id: gameIdObj },
            {
                $set: {
                    carrotRate: averageRating,
                    reviews: reviews
                }
            }
        );
      
        await usersCollection.updateOne(
            {nickname: author},
            {
                $set: {
                    reviews: userReviews
                }
            }
        );
      
        console.log("Game and User documents updated successfully.");
        console.log(averageRating);
    }
  };


// ValidateNickname
exports = async function(changeEvent) {
    const insertedUser = changeEvent.fullDocument;
    
    const usersCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("users");
    const usersWithNickname = await usersCollection.find({nickname: insertedUser.nickname}).toArray();
    
    if(usersWithNickname.length > 1){
        console.log("User with this nickname already exists");
        await usersCollection.deleteOne(insertedUser);
    }
};


// UpdateUserOnAuctionInsert
exports = async function(changeEvent) {
    const insertedAuction = changeEvent.fullDocument;
    const ownerIdObj = BSON.ObjectId(insertedAuction.ownerID);
    
    const usersCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("users");
    const user = await usersCollection.findOne({_id: ownerIdObj});
    const userAuctions = user.auctions;
    
    userAuctions.push(insertedAuction);
    
    await usersCollection.updateOne(
        {_id: ownerIdObj},
        {
            $set: {
                auctions: userAuctions
            }
        }
    );
};


// UpdateAuctionStatusInUser
exports = async function(changeEvent) {
    const updatedAuction = changeEvent.fullDocument;
    const ownerIdObj = BSON.ObjectId(updatedAuction.ownerID);
    
    const usersCollection = context.services.get("rotten-carrots-database").db("rotten-carrots-database").collection("users");
    const user = await usersCollection.findOne({_id: ownerIdObj});
    const userAuctions = user.auctions;
    
    for(auction of userAuctions){
      if(auction._id.toString()==updatedAuction._id.toString()){
        auction.isActive = updatedAuction.isActive;
        break;
      }
    }
  
    await usersCollection.updateOne(
      {_id: ownerIdObj},
      {
        $set: {
          auctions: userAuctions
        }
      }
    );
  };