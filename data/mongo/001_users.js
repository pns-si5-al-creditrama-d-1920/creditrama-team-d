db.createUser(
    {
        user: "team-d",
        pwd: "jboss-team-d",
        roles:[
            {
                role: "readWrite",
                db:   "transactions_db"
            }
        ]
    }
);