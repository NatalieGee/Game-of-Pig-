hierarchical inheritance and overloading: hierarchical inheritance used to organize and limit access of data. 
overloading used on single player simulations. multiplayer simulations will overload the single player simulation. 

parent class holds functions
  playonce: 
  playOnce: 
  playOnce81to100: 
  PrintPlayerScoreSummary: 
  
  Simulation1:
  Simulation2:
  Simulation3:
  singleTurn:
  playingEntireGame
  
child 1 holds 
  singleTurn: REPLACEMENT METHOD MEANT TO OVERRIDE METHOD FROM PARENT CLASS
  
child 2 holds 
  PlayingEntireGame: REPLACEMENT METHOD MEANT TO OVERRIDE METHOD FROM PARENT CLASS
  
       _________________________________________
       |                                        |
       |               MAIN CLASS               |
       |________________________________________|
       
                            |
                            |
                            |
       _________________________________________
       |                                        |
       |                PARENT CLASS            |
       |________________________________________|
                  |                         |
                  |                         |
       _________________________________________
       |                                        |
       |                child 1                 |
       |________________________________________|
       
        _________________________________________
       |                                        |
       |                child 2                 |
       |________________________________________|
       
       

Game of Pig Rules: You and the computer, acting as your opponent, both roll a dice and accumulate your total dice rolls value to 100. First to 100 wins. A player must roll as many dice as they want, and then finish their turn for their sum to be accumulated into their 'total score'. Sounds straightforward right? Well there's a catch. If a player rolls a zero, their accumulated points within their turn are null and their turn ends. Players can choose to roll or to finish their turn after however many rolls they want and add their points to the sum. Your opponent, the computer, likes accumulating 20 points before passing so play wisely!
