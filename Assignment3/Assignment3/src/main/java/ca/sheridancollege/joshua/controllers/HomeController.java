package ca.sheridancollege.joshua.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.joshua.beans.Player;
import ca.sheridancollege.joshua.repositories.DatabaseAccess;


@Controller
public class HomeController {
	
	@Autowired
    private DatabaseAccess da;
	
	@GetMapping("/")
	public String goIndex1() {
		return "index.html";
	}
	
	@GetMapping("/user")
	public String goIndex2() {
		return "/user/index.html";
	}
	
	@GetMapping("/home")
	public String goHome(Model model, HttpSession session) {
		
		
		session.setAttribute("message","2-D Traveller");
		
		return "home.html";
	}
	
	@PostMapping("/formPost")
		public String results(Model model, HttpSession session, @RequestParam int rows, @RequestParam int columns,
			@RequestParam String name,@RequestParam int numTurns,@RequestParam int xPos ,
			@RequestParam int yPos) {
		

		Player player = new Player();
		
		session.setAttribute("name","Hello there, Lord " + name);
		session.setAttribute("userAns","You entered there to be: " + rows + " rows" + " & " + columns + " columns");
		session.setAttribute("numMoves","Your traveller will have this many turns:  " + numTurns);
		session.setAttribute("yPos","You chose " + yPos + " as your Y position");
		session.setAttribute("xPos","You chose " + xPos + " as your X position");
		

        player.setName(name);
	
		int count= 0; 
	
		int currentXPos = 0;
		int currentYPos = 0;	
		
		ArrayList<Integer> xAxis = new ArrayList<Integer>();
		ArrayList<Integer> yAxis = new ArrayList<Integer>();
		
		for(int i = 0; i < columns; i++) { yAxis.add(i); }
		
		for(int i = 0; i < rows; i++) { xAxis.add(i); }
		
		player.setxPos(xPos);
        player.setyPos(yPos);
        player.setNumTurns(numTurns);
		
		currentYPos = yPos;
		currentXPos = xPos;
		
		if (currentYPos == 0) { currentYPos = yAxis.get(yAxis.size()/2); }
		
		if (currentXPos == 0) { currentXPos = xAxis.get(xAxis.size()/2); }
		
		System.out.println(" ");
		
		Random random = new Random();
		
	try {
			for(int i = 0; i < numTurns; i++) {
				
			int moveDecider = random.nextInt(10);
							
			if(moveDecider == 1 ) {
				
						currentYPos = currentYPos + 2;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
								count++;
								
				
						currentXPos = currentXPos + 1;
							System.out.println("the traveller's Xposition is @ " + xAxis.get(currentXPos) + " , " + name +" moved to the right once");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
							
					}else if (moveDecider == 2 ){
						
						currentYPos = currentYPos - 1;
							System.out.println("the traveller Yposition is  @ " + yAxis.get(currentYPos) + " , " + name +" has moved down once");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
							
					}else if(moveDecider == 3 ) {
						
						currentYPos = currentYPos + 2;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
							
					}else if(moveDecider == 4 ) {
						
						currentXPos = currentXPos + 2;
							System.out.println("the traveller Xposition is @ " + xAxis.get(currentXPos) + " , " + name +" has moved up twice ");
								count++;
								
						
						currentYPos = currentYPos + 2;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
						
					}else if(moveDecider == 5 ) {
						
						currentYPos = currentYPos + 3;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up trice ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
						
					}else if(moveDecider == 6 ) {
						
						currentXPos = currentXPos + 2;
							System.out.println("the traveller Xposition is @ " + xAxis.get(currentXPos) + " , " + name +" has moved up twice ");
								count++;
						
						currentYPos = currentYPos - 3;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved down trice  ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
						
					}else if(moveDecider == 7 ) {
						
						currentYPos = currentYPos + 4;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
					
					}else if(moveDecider == 8 ) {
						
							currentXPos = currentXPos + 2;
								System.out.println("the traveller Xposition is @ " + xAxis.get(currentXPos) + " , " + name +" has moved up twice ");
									count++;
								
						currentYPos = currentYPos - 4;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved down four times  ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
							
					}else if(moveDecider == 9 ) {
						
						currentYPos = currentYPos + 2;
							System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
								System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
									count++;
									System.out.println(" ");
							
					}else if(moveDecider == 10 ) {
						
							currentYPos = currentYPos + 2;
								System.out.println("the traveller Yposition is @ " + yAxis.get(currentYPos) + " , " + name +" has moved up twice ");
									count++;
							
							currentXPos = currentXPos + 1;
								System.out.println("the traveller's Xposition is @ " + xAxis.get(currentXPos) + " , " + name +" moved to the right once");
									System.out.println("the traveller's current postition  is  X:" + xAxis.get(currentXPos) +" Y:" +  yAxis.get(currentYPos) );
										count++;
										System.out.println(" ");
					}	}
			
			} catch (Exception e) {
			
			}
			
	double avgMoves = count / numTurns;
	player.setAvgMoves(count / numTurns);
			
			System.out.println("the number of moves is " + count);
		
			

			        double standardDeviation = 0.0;
				        double mean = numTurns /count;
				        for (double i = 0; i < count; i++)
				        { standardDeviation += Math.pow((double) i - (double) mean, 2);  }
				        
				        double standardDev = Math.sqrt(standardDeviation/count) ;
				        
				        session.setAttribute("StandardDev","The Standard Deviation of Moves by Player : " + standardDev);
				        player.setStanDev(standardDev);
				        
				       
				        model.addAttribute("player", player);
				        
				        da.insertInformation(player);
				        
return"results.html";
	}
	
	@GetMapping("/login")
	public String goLogin() {
		return "login.html";
	}
	@GetMapping("/access-denied")
	public String goAccessDenied() {
	return "/error/access-denied.html";
	}

}
