const sql = require("./db.js");

// constructor
const Score = function(score) {
  this.username = score.username;
  this.score = score.score;
};

Score.create = (newScore, result) => {
  sql.query("INSERT INTO scores SET ?", newScore, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }
    console.log("score added ", res);
    result(null, res);
  });
};

Score.getAll = (title, result) => {
  let query = "SELECT * FROM scores";

  sql.query(query, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }
    console.log("score: ", res);
    result(null, res);
  });
};
module.exports = Score;


