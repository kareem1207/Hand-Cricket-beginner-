package GamePkg;
import java.util.Scanner;
// game is successful  and completed
class start{
	// toss decider
	static int decision;
public static int toss(int p1,int p2,int d) {
	int tossWinner=0;
	if (d==1 && (p1+p2)%2!=0){
		System.out.println("Odd");
		tossWinner=1;
	}
	else if (d==2 && (p1+p2)%2==0) {
		System.out.println("Even");
		tossWinner=2;
	}
	else if (d==1 && (p1+p2)%2==0) {
		System.out.println("Even");
		tossWinner=3;
	}
	else if (d==2 && (p1+p2)%2!=0) {
		System.out.println("Odd");
		tossWinner=4;
	}
	
	return tossWinner;
}
// for finding eve or odd
public static int desicion () {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter\n1----->Odd\n2----->Even");
	int pc =s.nextInt();
	if (pc==1 || pc==2) 
	return pc;
	else 
		System.out.println("Wrong Input");
	System.exit(0);
	return 0;
}
// choosing bat or ball
public static void  position(int pos,int gw) {
	Scanner s= new Scanner(System.in);
	if (pos==1 || pos == 2) {
		System.out.println("Player won");
		System.out.println("Enter\n1---->Batting\n2----->Bowling");
		decision=s.nextInt();
		if (decision !=1 && decision!=2) {
			System.out.println("Wrong Input");
			System.exit(0);
		}
	}
	else if (pos ==3 || pos == 4) {
		System.out.println("Player lost");
		if (gw==1) {
			System.out.print("Ai choose ");
			if (Aigenerator.tempai() %2 == 0){
				System.out.println("Bowling");
				decision =4;
			}
			else {
				System.out.println("Batting");
				decision =3;
			}
		}
		else {
			System.out.println("Seecond Player won");
			System.out.println("Enter\n1---->Batting\n2----->Bowling");
			decision=s.nextInt();
			if (decision !=1 && decision!=2) {
				System.out.println("Wrong Input");
				System.exit(0);
			}
		}
	}
//	return decision;
}
}
// decision --> p1 batting , decision -->2 p1 bowling , decision -->3 p2 batting decision --> 4 p2 bowling 
class Game extends start{
	public static int gameplay(int gw) {
		Scanner s =new Scanner(System.in);
		System.out.println("Start the game");
		boolean stop=true;
		int p1 = 0,p2 =1;
		int points=0 ;
		if (gw==1){
			if (handcricket.pratical_gameMode)
			while (stop ){
				if (handcricket.over_presence) {
					int overs=6;
					if (handcricket.over!=0){
					overs*=handcricket.over;
					if ((handcricket.over>=1) && (overs!=0)) {
						--overs;
					}
					else if (overs==0) {
						System.out.println("Overs are over");
						stop=false;
					}
				}
				}
				System.out.println("Player 1 enter number");
				p1=s.nextInt();
				p2=Aigenerator.aiNumberGenerator(-1,6);
				System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
				if ((p1>=0 && p1<=6) && (p1!=p2)) {
					if (decision==1 || decision ==4)
					points+=p1;
					else if (decision==2 || decision==3)
						points+=p2;
				}
				else if (!(p1>=0 && p1<=6)) {
	               System.out.println("Write correctly one point is removed from player");
	               points--;
				}
				else if (p1==p2) {
					System.out.println("Game Over");
					stop=false;
				}
			}
			else if (handcricket.nonReal_gameMode) {
				while (stop ){
					if (handcricket.over_presence) {
						int overs=6;
						if (handcricket.over!=0){
						overs*=handcricket.over;
						if ((handcricket.over>=1) && (overs!=0)) {
							--overs;
						}
						else if (overs==0) {
							System.out.println("Overs are over");
							stop=false;
						}
					}
					}
					p1=s.nextInt();
					int p2_choice=Aigenerator.aiNumberGenerator(-1,4);
					switch(p2_choice) {
					case 0:
					case 1:
					case 2:
					case 3:
						p2=Aigenerator.aiNumberGenerator(-1,9);
						break;
					case 4:
					case 5:
						p2=20;
						break;
						
					}
					System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
					switch(p1) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 20:
						if (decision==1 || decision ==4)
							points+=p1;
							else if (decision==2 || decision==3)
								points+=p2;
						break;
					case 0:
						if (decision==1 || decision ==4)
							points+=p2;
							else if (decision==2 || decision==3)
								points+=p1;
						break;
					default:
						System.out.println("Wrong input one point is deducted");
						points--;
					}
					 if (p1==p2) {
						System.out.println("Game Over");
						stop=false;
					}
				}
			}
		}
		else if (gw==2){
			if (handcricket.pratical_gameMode)
			while (stop ){
				System.out.println("Player 1 enter number");
				p1=s.nextInt();
				System.out.println("Player 2 enter number");
				p2=s.nextInt();
				System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
				if ((p1>=0 && p1<=6) && (p1!=p2)) {
					if (decision==1 || decision ==4)
						points+=p1;
						else if (decision==2 || decision==3)
							points+=p2;
				}
				else if (!(p1>=0 && p1<=6)) {
	               System.out.println("Write correctly one point is removed from player");
	               points--;
				}
				 if (handcricket.over_presence) {
					int overs=6;
					if (handcricket.over!=0){
					overs*=handcricket.over;
					if ((handcricket.over>=1) && (overs!=0)) {
						--overs;
					}
					else if (overs==0) {
						System.out.println("Overs are over");
						stop=false;
					}
				}
				}
				else if (p1==p2) {
					System.out.println("Game Over");
					stop=false;
				}
			}
			else if (handcricket.nonReal_gameMode) {
				while (stop ){
					 if (handcricket.over_presence) {
							int overs=6;
							if (handcricket.over!=0){
							overs*=handcricket.over;
							if ((handcricket.over>=1) && (overs!=0)) {
								--overs;
							}
							else if (overs==0) {
								System.out.println("Overs are over");
								stop=false;
							}
						}
						}
					System.out.println("Player 1 enter number");
					p1=s.nextInt();
					System.out.println("Player 2 enter number");
					p2=s.nextInt();
					System.out.println("Player choice ---->"+p1+"\n"+"Player 2 choice ---->"+p2);
					switch(p1) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 20:
						points++;
						break;
					case 0:
						points+=p2;
						break;
					default:
						System.out.println("Wrong input one point is deducted");
						points--;
					}
					 if (p1==p2) {
						System.out.println("Game Over");
						stop=false;
					}
				}
			}
		}
		return points;
	}
	public static int gameplay2(int gw,int p) {		
		Scanner s =new Scanner(System.in);
		System.out.println("Start the game");
		boolean stop=true;
		int p1 = 0,p2 =1;
		int points=0 ;
		if (gw==1){
			if (handcricket.pratical_gameMode)
			while (stop ){
				if (points>p)
					stop=false;
				if (handcricket.over_presence) {
					int overs=6;
					if (handcricket.over!=0){
					overs*=handcricket.over;
					if ((handcricket.over>=1) && (overs!=0)) {
						overs--;
					}
					else if (overs==0) {
						System.out.println("Overs are over");
						stop=false;
					}
				}
				}
				System.out.println("Player 1 enter number");
				p1=s.nextInt();
				p2=Aigenerator.aiNumberGenerator(-1,6);
				System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
				if ((p1>=0 && p1<=6) && (p1!=p2)) {
					if (decision==1 || decision ==4)
						points+=p1;
						else if (decision==2 || decision==3)
							points+=p2;
				}
				else if (!(p1>=0 && p1<=6)) {
	               System.out.println("Write correctly one point is add to player 2");
	               ++points;
				}
				else if (p1==p2) {
					System.out.println("Game Over");
					stop=false;
				}
			}
			else if (handcricket.nonReal_gameMode) {
				while (stop ){
					if (points>p)
						stop=false;
					if (handcricket.over_presence) {
						int overs=6;
						if (handcricket.over!=0){
						overs*=handcricket.over;
						if ((handcricket.over>=1) && (overs!=0)) {
							--overs;
						}
						else if (overs==0) {
							System.out.println("Overs are over");
							stop=false;
						}
					}
					 }
					p1=s.nextInt();
					int p2_choice=Aigenerator.aiNumberGenerator(-1,4);
					switch(p2_choice) {
					case 0:
					case 1:
					case 2:
					case 3:
						p2=Aigenerator.aiNumberGenerator(-1,9);
						break;
					case 4:
					case 5:
						p2=20;
						
					}
					System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
					switch(p1) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 20:
						if (decision==1 || decision ==4)
							points+=p1;
							else if (decision==2 || decision==3)
								points+=p2;
						break;
					case 0:
						if (decision==1 || decision ==4)
							points+=p2;
							else if (decision==2 || decision==3)
								points+=p1;
						break;
					default:
						System.out.println("Wrong input one point is add to player 2");
						--points;
					}
					 if (p1==p2) {
						System.out.println("Game Over");
						stop=false;
					}
					
				}
			}
		}
		else if (gw==2){
			if (handcricket.pratical_gameMode)
			while (stop ){
				if (points>p)
					stop=false;
				System.out.println("Player 1 enter number");
				p1=s.nextInt();
				System.out.println("Player 2 enter number");
				p2=s.nextInt();
				System.out.println("Player choice ---->"+p1+"\n"+"Player 2 ---->"+p2);
				if ((p1>=0 && p1<=6) && (p1!=p2)) {
					++points;
				}
				else if (!(p1>=0 && p1<=6)) {
	               System.out.println("Write correctly one point is removed from player");
	               --points;
				}
				 if (handcricket.over_presence) {
					int overs=6;
					if (handcricket.over!=0){
					overs*=handcricket.over;
					if ((handcricket.over>=1) && (overs!=0)) {
						--overs;
					}
					else if (overs==0) {
						System.out.println("Overs are over");
						stop=false;
					}
				}
				}
				else {
					System.out.println("Game Over");
					stop=false;
				}
			}
			else if (handcricket.nonReal_gameMode) {
				while (stop ){
					if (points>p)
						stop=false;
					 if (handcricket.over_presence) {
							int overs=6;
							if (handcricket.over!=0){
							overs*=handcricket.over;
							if ((handcricket.over>=1) && (overs!=0)) {
								--overs;
							}
							else if (overs==0) {
								System.out.println("Overs are over");
								stop=false;
							}
						}
						}
					System.out.println("Player 1 enter number");
					p1=s.nextInt();
					System.out.println("Player 2 enter number");
					p2=s.nextInt();
					System.out.println("Player choice ---->"+p1+"\n"+"AI choice ---->"+p2);
					switch(p1) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 20:
						
						++points;
						break;
					case 0:
						points+=p2;
						break;
					default:
						System.out.println("Wrong input one point is deducted");
						--points;
					}
					 if (p1==p2) {
						System.out.println("Game Over");
						stop=false;
					}
				}
			}
		}
		return points;
	}
	public static void winner(int gw) {
		int target=gameplay(gw);
		if (decision==1){
			System.out.println("Since Player choosed batting and seted a target of "+target+" to other player .");
			System.out.println("Now other player will be batting ");
			int target2=gameplay2(gw,target);
			if (target>target2)
				System.out.println("Player 1 is the Winner");
			else if (target==target2)
				System.out.println("It's a tie");
			else if (target2<target)
				System.out.println("Player 2 won");
		}
		else if (decision==2){
			System.out.println("Since Player choosed bowling and other Player seted a target of "+target+" to first player .");
			System.out.println("Now First player will be batting ");
			int target2=gameplay2(gw,target);
			if (target>target2)
				System.out.println("Player 2 is the Winner");
			else if (target==target2) 
				System.out.println("It's a tie");
			else if (target2<target)
				System.out.println("Player 1 won");
		}
		else if (decision==3){
			System.out.println("Since Second Player choosed batting and seted a target of "+target+" to First player .");
			System.out.println("Now First player will be batting ");
			int target2=gameplay2(gw,target);
			if (target>target2)
				System.out.println("Player 2 is the Winner");
			else if (target==target2)
				System.out.println("It's a tie");
			else if (target2<target)
				System.out.println("Player 1 won");
		}
		else if (decision==4){
			System.out.println("Since Second Player choosed bowling and other player seted a target of "+target+" to second player .");
			System.out.println("Now other Second player will be batting ");
			int target2=gameplay2(gw,target);
			if (target>target2)
				System.out.println("Player 1 is the Winner");
			else if (target==target2)
				System.out.println("It's a tie");
			else if (target2<target)
				System.out.println("Player 2 won");
		}
	}
}
// completed 
public class handcricket {
  static boolean pratical_gameMode;
  static boolean nonReal_gameMode;
  static boolean over_presence=false;
  static int over =0;
  public static void game_decider() {
	  int o=1;
	  String any="Any number execpt 1,2 and 3";
	  Scanner s = new Scanner(System.in);
		while(o!=0) {
			System.out.println("Enter\n1----->Pratical Game mode\n2----->Non Pratical Game mode\n3----->Help\n"+any+"----->Quit");
			int game_mode=s.nextInt();
		if (game_mode==1) {
			pratical_gameMode=true;
			nonReal_gameMode=false;
			o=0;
		}
		else if (game_mode==2) {
			pratical_gameMode=false;
			nonReal_gameMode=true;	
			o=0;
		}
		else if(game_mode==3){
			System.out.println("Enter\n1----->To know about Pratical Game mode\n2----->To know about Non Pratical Game mode\n3----->To go back to Game mode choosing menu\n4----->To Quit");
			int help=s.nextInt();
			switch(help) {
			case 1:
				System.out.println("It involves numbering from 0 to 6 and 0 means 0 only ");
				o=1;
				break;
			case 2:
				System.out.println("It involves numbering from 0 to 10 and 20 also and 0 sum of other player number only ");
				o=1;
				break;
			case 3:
				o=1;
				break;
			case 4 :
				System.exit(0);
			default :
				System.out.println("Wrong error you idiot ");
				System.exit(0);
			}
		}
		else 
			System.exit(0);
		}
		o=1;
		while(o!=0) {
			System.out.println("Enter\n1----->Overs match\n2----->Non Overs match\n3----->Help");
			int govers=s.nextInt();
			if (govers==1){
				over_presence=true;
				System.out.println("Enter Number of overs you want :(0 means infinite )\n ");
				over=s.nextInt() ;
				o=0;
			}
			else if (govers==2) {
				over_presence=false;
				over=0;
				o=0;
			}
			else if(govers==3){
				System.out.println("Enter\n1----->Overs match\n2----->Non Overs match\n3----->To go back to Overs choosing menu\n4----->To Quit");
				int help=s.nextInt();
				switch(help) {
				case 1:
					System.out.println("There will be overs");
					o=1;
					break;
				case 2:
					System.out.println("There will be no overs ");
					o=1;
					break;
				case 3:
					o=1;
					break;
				case 4 :
					System.exit(0);
				}
			}
			else 
				System.exit(0);
			}
		}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int p1,p2 = 0,o=1;
		game_decider();
		System.out.println("Enter\n1----->To play with AI\n2----->To play with Other offline player");
		int game_way=s.nextInt();
		if (game_way==1 || game_way==2) {
		int pc=start.desicion();
		System.out.println("Enter number");
		p1=s.nextInt();
		if (game_way==1)
		   p2=Aigenerator.aiNumberGenerator(-1,6);	
		else if (game_way==2) 
			p2=s.nextInt();
		int toss_winner=Game.toss(p1, p2, pc);
         Game.position(toss_winner,game_way); 
         Game.winner(game_way);
		}else 
			System.out.println("Wrong input");
	}
}