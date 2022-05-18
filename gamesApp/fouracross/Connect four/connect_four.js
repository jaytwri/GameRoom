// We need to use jQuery for the following:

var player1 = prompt("Player One: NAME , BLUE");
var player1Color = 'rgb(86, 151, 255)';

var player2 = prompt("Player Two: NAME, RED");
var player2Color = 'rgb(237, 45, 73)';

var game_on = true;
var table = $('table tr');

 
function reportWin(rowNum,colNum) {
  console.log("You won starting at this row,col");
  console.log(rowNum);
  console.log(colNum);
}
 
function setColor(rowIndex,colIndex,color) {
  return table.eq(rowIndex).find('td').eq(colIndex).find('button').css('background-color',color);
}

 
function getColor(rowIndex,colIndex) {
  return table.eq(rowIndex).find('td').eq(colIndex).find('button').css('background-color');
}

 
function checkBottom(colIndex) {
  var colorReport = getColor(5,colIndex);
  for (var row = 5; row > -1; row--) {
    colorReport = getColor(row,colIndex);
    if (colorReport === 'rgb(128, 128, 128)') {
      return row
    }
  }
}

 
function colorMatchCheck(one,two,three,four){
  return (one===two && one===three && one===four && one !== 'rgb(128, 128, 128)' && one !== undefined);
}

 
function checkHorizontalWin() {
  for (var row = 0; row < 6; row++) {
    for (var col = 0; col < 4; col++) {
      if (colorMatchCheck(getColor(row,col), getColor(row,col+1) ,getColor(row,col+2), getColor(row,col+3))) {
        console.log('horiz');
        reportWin(row,col);
        return true;
      }else {
        continue;
      }
    }
  }
}

 
function checkVerticalWin() {
  for (var col = 0; col < 7; col++) {
    for (var row = 0; row < 3; row++) {
      if (colorMatchCheck(getColor(row,col), getColor(row+1,col) ,getColor(row+2,col), getColor(row+3,col))) {
        console.log('vertical');
        reportWin(row,col);
        return true;
      }else {
        continue;
      }
    }
  }
}

 
function checkDiagonalWin() {
  for (var col = 0; col < 5; col++) {
    for (var row = 0; row < 7; row++) {
      if (colorMatchCheck(getColor(row,col), getColor(row+1,col+1) ,getColor(row+2,col+2), getColor(row+3,col+3))) {
        console.log('diag');
        reportWin(row,col);
        return true;
      }else if (colorMatchCheck(getColor(row,col), getColor(row-1,col+1) ,getColor(row-2,col+2), getColor(row-3,col+3))) {
        console.log('diag');
        reportWin(row,col);
        return true;
      }else {
        continue;
      }
    }
  }
}

 
function gameEnd(winningPlayer) {
  for (var col = 0; col < 7; col++) {
    for (var row = 0; row < 7; row++) {
      $('h3').fadeOut('fast');
      $('h2').fadeOut('fast');
      $('h1').text(winningPlayer+" won! Refresh to play again!").css("fontSize", "60px")
    }
  }
}

 
var cur_player = 1;
var cur_name = player1;
var cur_color = player1Color;

$('h3').text(player1+": Your turn, pick a column to place your blue chip.");

$('.board button').on('click',function() {

 
  var col = $(this).closest("td").index();

 
  var bottomAvail = checkBottom(col);

 
  setColor(bottomAvail,col,cur_color);

 
  if (checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin()) {
    gameEnd(cur_name);
  }

 
  cur_player = cur_player * -1 ;

 
  if (cur_player === 1) {
    cur_name = player1;
    $('h3').text(cur_name+": Your turn, pick a column to drop your blue chip.");
    cur_color = player1Color;
  }else {
    cur_name = player2
    $('h3').text(cur_name+": Your turn, pick a column to drop your red chip.");
    cur_color = player2Color;
  }

})

 