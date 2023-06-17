// news
JG.repeat(100, 100, {
    author: JG.firstName() + JG.integer(),
    title: JG.loremIpsum({units: 'words', count: 4}),
    content: JG.loremIpsum({units: 'words', count: 20}),
    publicationDate: JG.date(),
    _class: "com.rotten.carrots.News.News"
  });


// game
JG.repeat(100, 100, {
	reviews: [],
	title: JG.loremIpsum({units: 'words', count: 3}),
  	genre: JG.loremIpsum({units: 'words', count: 1}),
  	description: JG.loremIpsum({units: 'words', count: 25}),
  	developer: JG.company(),
  	releaseDate: JG.date(new Date(2018, 0, 1), new Date(2023, 0, 1)),
  	msrp: JG.integer(30, 100),
  	carrotRate: -1,
	_class: "com.rotten.carrots.Game.Game"
});


// user
JG.repeat(30, 30, {
    nickname: JG.firstName() + JG.integer(),
  reviews: [],
  activeAuctions: [],
    finishedAuctions: [],
    favouriteGames: [],
  _class: "com.rotten.carrots.User.User"
});


// auction
JG.repeat(100, 100, {
  game:{
    "$ref": "games",
    "$id": {
      "$oid": JG.random("648cd611020f97c10309f01b",
                       "648cd611020f97c10309f01c",
                       "648cd611020f97c10309f01d",
                       "648cd611020f97c10309f01e",
                       "648cd611020f97c10309f01f",
                       "648cd611020f97c10309f020",
                       "648cd611020f97c10309f021",
                       "648cd611020f97c10309f022",
                       "648cd611020f97c10309f023",
                       "648cd611020f97c10309f024",
                       "648cd611020f97c10309f025",
                       "648cd611020f97c10309f026",
                       "648cd611020f97c10309f029",
                       "648cd611020f97c10309f02b",
                       "648cd611020f97c10309f030",
                       "648cd611020f97c10309f033",
                       "648cd611020f97c10309f036",
                       "648cd611020f97c10309f039",
                       "648cd611020f97c10309f03d",
                       "648cd611020f97c10309f040",
                       "648cd611020f97c10309f044",
                       "648cd611020f97c10309f04a",
                       "648cd611020f97c10309f04d",
                       "648cd611020f97c10309f050",
                       "648cd611020f97c10309f056",
                       "648cd611020f97c10309f05b",
                       "648cd611020f97c10309f062",
                       "648cd611020f97c10309f067",
                       "648cd611020f97c10309f06a",
                       "648cd611020f97c10309f06c",
                       "648cd611020f97c10309f06f",
                       "648cd611020f97c10309f074")
    }
  },
  owner:{
    "$ref": "users",
    "$id": {
      "$oid": JG.random("648cd57d020f97c10309eff3",
                       "648cd57d020f97c10309eff4",
                       "648cd57d020f97c10309eff5",
                       "648cd57d020f97c10309eff6",
                       "648cd57d020f97c10309eff8",
                       "648cd57d020f97c10309effb",
                       "648cd57d020f97c10309effd",
                       "648cd57d020f97c10309effe",
                       "648cd57d020f97c10309f000",
                       "648cd57d020f97c10309f004",
                       "648cd57d020f97c10309f005",
                       "648cd57d020f97c10309f008",
                       "648cd57d020f97c10309f00b",
                       "648cd57d020f97c10309f00e",
                       "648cd57d020f97c10309f010")
    }
  },
  description: JG.loremIpsum({units: 'words', count: 10}),
  price: JG.floating(5, 40, 2),
  publicationDate: JG.date(new Date(2018, 0, 1), new Date(2023, 0, 1)),
  isActive: JG.bool(),
  _class: "com.rotten.carrots.Auctions.Auction"
});


  // reviews
  JG.repeat(100, 100, {
    gameID: JG.random("648cd611020f97c10309f01b",
                         "648cd611020f97c10309f01c",
                         "648cd611020f97c10309f01d",
                         "648cd611020f97c10309f01e",
                         "648cd611020f97c10309f01f",
                         "648cd611020f97c10309f020",
                         "648cd611020f97c10309f021",
                         "648cd611020f97c10309f022",
                         "648cd611020f97c10309f023",
                         "648cd611020f97c10309f024",
                         "648cd611020f97c10309f025",
                         "648cd611020f97c10309f026",
                         "648cd611020f97c10309f029",
                         "648cd611020f97c10309f02b",
                         "648cd611020f97c10309f030",
                         "648cd611020f97c10309f033",
                         "648cd611020f97c10309f036",
                         "648cd611020f97c10309f039",
                         "648cd611020f97c10309f03d",
                         "648cd611020f97c10309f040",
                         "648cd611020f97c10309f044",
                         "648cd611020f97c10309f04a",
                         "648cd611020f97c10309f04d",
                         "648cd611020f97c10309f050",
                         "648cd611020f97c10309f056",
                         "648cd611020f97c10309f05b",
                         "648cd611020f97c10309f062",
                         "648cd611020f97c10309f067",
                         "648cd611020f97c10309f06a",
                         "648cd611020f97c10309f06c",
                         "648cd611020f97c10309f06f",
                         "648cd611020f97c10309f074",
                     "648cd611020f97c10309f025"),
  	author: JG.random("Jean6", "Ayers1", "Christi7",
                     "Hoffman3", "Shaffer10", "Karyn5",
                     "Jenna8", "Angelica9", "Anderson10",
                     "Alvarado3", "Torres10", "Jayne7",
                     "Lowery6", "Jenkins4", "Holland7",
                     "Beth7", "Cynthia4", "Juanita9",
                     "Sondra7", "Irene1"),
    content: JG.loremIpsum({units: 'words', count: 10}),
    carrotRate: JG.integer(1, 100),
    publicationDate: JG.date(new Date(2018, 0, 1), new Date(2023, 0, 1)),
    _class: "com.rotten.carrots.Review.Review"
  });