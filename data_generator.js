// news
JG.repeat(200, 200, {
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
  	genre: JG.random("Action", "Adventure", "RPG", "Simulation", "Strategy", "Sports", "MMO", "Puzzle", "Idle", "Casual", "Arcade", "Racing", "Fighting", "Shooter", "Platformer", "Stealth", "Survival", "Horror", "Battle Royale", "Rhythm", "Sandbox", "Educational", "Board Game", "Card Game", "Party Game", "Tower Defense", "Real-Time", "Tactical"),
  	description: JG.loremIpsum({units: 'words', count: 35}),
  	developer: JG.random("Ubisoft", "Riot Games", "Blizzard", "Valve", "Electronic Arts", "Activision", "Epic Games", "Rockstar Games", "Bethesda", "Square Enix", "Nintendo", "Sony", "Microsoft", "Capcom", "Konami", "Bandai Namco", "CD Projekt Red", "2K Games", "Bungie", "Telltale Games", "Naughty Dog", "Insomniac Games", "From Software", "Platinum Games", "Kojima Productions", "Guerrilla Games", "Crystal Dynamics", "Gearbox Software", "BioWare", "Sucker Punch Productions", "Remedy Entertainment", "Respawn Entertainment", "Rare"),
  	releaseDate: JG.date(new Date(2018, 0, 1), new Date(2023, 0, 1)),
  	msrp: JG.integer(30, 100),
  	carrotRate: -1,
	_class: "com.rotten.carrots.Game.Game"
});


// user
JG.repeat(30, 30, {
    nickname: JG.firstName() + JG.integer(),
    reviews: [],
    auctions: [],
    favouriteGames: [],
    _class: "com.rotten.carrots.User.User"
});


// auction
JG.repeat(100, 100, {
  game:{
    "$ref": "games",
    "$id": {
        "$oid": JG.random(  "648d71a3020f97c10309f2b6",
                            "648d71a3020f97c10309f2b7",
                            "648d71a3020f97c10309f2b8",
                            "648d71a3020f97c10309f2b9",
                            "648d71a3020f97c10309f2ba",
                            "648d71a3020f97c10309f2bb",
                            "648d71a3020f97c10309f2bc",
                            "648d71a3020f97c10309f2bd",
                            "648d71a3020f97c10309f2be",
                            "648d71a3020f97c10309f2bf",
                            "648d71a3020f97c10309f2c0",
                            "648d71a3020f97c10309f2c1",
                            "648d71a3020f97c10309f2c2",
                            "648d71a3020f97c10309f2c3",
                            "648d71a3020f97c10309f2c4",
                            "648d71a3020f97c10309f2c5",
                            "648d71a3020f97c10309f2c6",
                            "648d71a3020f97c10309f2c7",
                            "648d71a3020f97c10309f2c8",
                            "648d71a3020f97c10309f2c9",
                            "648d71a3020f97c10309f2ca",
                            "648d71a3020f97c10309f2cb",
                            "648d71a3020f97c10309f2cc",
                            "648d71a3020f97c10309f2cd",
                            "648d71a3020f97c10309f2ce",
                            "648d71a3020f97c10309f2cf",
                            "648d71a3020f97c10309f2d0",
                            "648d71a3020f97c10309f2d1",
                            "648d71a3020f97c10309f2d2",
                            "648d71a3020f97c10309f2d3",
                            "648d71a3020f97c10309f2d4",
                            "648d71a3020f97c10309f2d5")
    }
  },
  owner:{
    "$ref": "users",
    "$id": {
        "$oid": JG.random(  "648d724e020f97c10309f31c",
                            "648d724e020f97c10309f31d",
                            "648d724e020f97c10309f31e",
                            "648d724e020f97c10309f31f",
                            "648d724e020f97c10309f320",
                            "648d724e020f97c10309f321",
                            "648d724e020f97c10309f322",
                            "648d724e020f97c10309f323",
                            "648d724e020f97c10309f324",
                            "648d724e020f97c10309f325",
                            "648d724e020f97c10309f326",
                            "648d724e020f97c10309f327",
                            "648d724e020f97c10309f328",
                            "648d724e020f97c10309f329",
                            "648d724e020f97c10309f32a",
                            "648d724e020f97c10309f32b",
                            "648d724e020f97c10309f32c",
                            "648d724e020f97c10309f32d",
                            "648d724e020f97c10309f32e",
                            "648d724e020f97c10309f32f")
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
    gameID: JG.random(  "648d71a3020f97c10309f2b6",
                        "648d71a3020f97c10309f2b7",
                        "648d71a3020f97c10309f2b8",
                        "648d71a3020f97c10309f2b9",
                        "648d71a3020f97c10309f2ba",
                        "648d71a3020f97c10309f2bb",
                        "648d71a3020f97c10309f2bc",
                        "648d71a3020f97c10309f2bd",
                        "648d71a3020f97c10309f2be",
                        "648d71a3020f97c10309f2bf",
                        "648d71a3020f97c10309f2c0",
                        "648d71a3020f97c10309f2c1",
                        "648d71a3020f97c10309f2c2",
                        "648d71a3020f97c10309f2c3",
                        "648d71a3020f97c10309f2c4",
                        "648d71a3020f97c10309f2c5",
                        "648d71a3020f97c10309f2c6",
                        "648d71a3020f97c10309f2c7",
                        "648d71a3020f97c10309f2c8",
                        "648d71a3020f97c10309f2c9",
                        "648d71a3020f97c10309f2ca",
                        "648d71a3020f97c10309f2cb",
                        "648d71a3020f97c10309f2cc",
                        "648d71a3020f97c10309f2cd",
                        "648d71a3020f97c10309f2ce",
                        "648d71a3020f97c10309f2cf",
                        "648d71a3020f97c10309f2d0",
                        "648d71a3020f97c10309f2d1",
                        "648d71a3020f97c10309f2d2",
                        "648d71a3020f97c10309f2d3",
                        "648d71a3020f97c10309f2d4",
                        "648d71a3020f97c10309f2d5",
                        "648d71a3020f97c10309f2f3",
                        "648d71a3020f97c10309f2f8",
                        "648d71a3020f97c10309f2fc",
                        "648d71a3020f97c10309f302",
                        "648d71a3020f97c10309f305",
                        "648d71a3020f97c10309f307",
                        "648d71a3020f97c10309f30c",
                        "648d71a3020f97c10309f311",
                        "648d71a3020f97c10309f315",
                        "648d71a3020f97c10309f319",
                        "648d71a3020f97c10309f2f4"),
  	author: JG.random('Goldie4',   'Genevieve5',
                        'Edwina7',   'Mabel10',
                        'Arnold5',   'Jenifer2',
                        'Stella5',   'Crosby4',
                        'Griffith5', 'Pollard1',
                        'Adela6',    'Ladonna10',
                        'Amanda10',  'Townsend10',
                        'Pacheco6',  'Slater5',
                        'Vincent8',  'Carolyn7',
                        'Dawn8',     'Whitehead8',
                        'Cheri8',   'Concepcion6',
                        'Obrien2', 'Lucile6'),
    content: JG.loremIpsum({units: 'words', count: 10}),
    carrotRate: JG.integer(1, 100),
    publicationDate: JG.date(new Date(2018, 0, 1), new Date(2023, 0, 1)),
    _class: "com.rotten.carrots.Review.Review"
  });