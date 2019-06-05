# blackjack
Blackjack is a card game in which the objective is to get a hand that is as close as possible to 21, without going over. 
This casino game is also called 21.

- A player starts out with two cards and can request more cards, one at a time.

- Numeric cards have their numeric value, and all face cards (K,Q,J) have value 10.

- An ace (A) has the value 1 or 11, which ever value is more advantageous to the user.
	For example, a hand with two aces and one five has the value of 11 + 1 + 5 = 17.
	In this case, the second ace is counted as a value of 1, since if it were counted 11 the hand value would be 27.
	blackjack hand

- A two-card hand with an ace and 10 is always counted as 21, and is called a “blackjack" hand.

- The user of the program is the player and the program acts as the dealer. The program begins by dealing two cards each to the player 
  and the dealer. The values of player’s cards are shown. The value of one of the dealer’s card is shown, with the other value hidden 
  until the hand is over. The hidden dealer card is called the "hole" card. Once the player’s hand is dealt, the player inputs the 
  following one-character commands:

	h | take another card
	s | dealers play (dealers turn, only one turn and game is concluded)
	q | quit hand

- If the player’s hand value goes above 21, the player "busts" and loses the hand. The dealer reveals the hole card.

- If the player does not bust, or the player’s hand reaches a value of 21, then the dealer plays. This is done by the dealer taking 
  cards until the dealer’s hand value is 17 or higher or the dealer busts. At the conclusion of dealer play all dealer cards are revealed,
  including the hole card.

- If neither the player nor dealer busts, then the winning hand is the one with the higher value. If the hand values are the same, 
  then the hand is a tie, which is called a "push". A two-card blackjack hand beats a hand of value 21 with more than two cards.

- The dealer’s hole card is displayed as ’X’. When the player’s hand value reaches 21, the player is not prompted for a command, 
  and the dealer’s play commences automatically.

- If the player uses the ’q’ command, the player loses immediately. The dealer does not play, and the hole card is not revealed. 
  The dealer wins.


					***********************************
					******* Sample Basic Play *********
					***********************************

Player’s Hand: 3, J
Dealer’s Hand: 5, X

Enter command: h

Player’s Hand: 3, J, 9
Dealer’s Hand: 5, 2

Player busts.

Enter ’q’ to quit, anything else to play another game c

Player’s Hand: K, 8
Dealer’s Hand: 9, X

Enter command: s

Player’s Hand: K, 8
Dealer’s Hand: 9, 3, 10

Dealer busts.

Player’s Hand: A, Q
Dealer’s Hand: 3, 8, 10

Player wins.

Enter ’q’ to quit, anything else to play another hand: q

Total Score
Dealer wins=0
Player wins=1
