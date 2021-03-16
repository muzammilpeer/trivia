package com.trivia.pkg;

import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SetupDatabase extends Activity {

	private static final String NULL = null;
	DatabaseManager db;
	 
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	// this try catch block returns better error reporting to the log
    	try
    	{
	        // Android specific calls
    		super.onCreate(savedInstanceState);
	        setContentView(R.layout.setupdatabase);
 
	        // create the database manager object
	        db = new DatabaseManager(this);
	        LoadSampleQueries();
	     }    
    	catch (Exception e)
    	{
    		Log.e("ERROR", e.toString());
    		e.printStackTrace();
    	}

    }
	public void nextScreenHandler(View target)
	{
		// Create new intent object and tell it to call the ColorPicker class
		Intent question = new Intent(this, com.trivia.pkg.MasterScreen.class);
		// Start ColorPicker as a new activity and wait for the result 
		this.startActivity(question);

	}
    private void InitializeSampleData()
    {
    	try
    	{
    		//addRow_Movie(String title, String review,float score,String link1, String link2,String link3)
    		//addRow_Quote(int movie_id,String text,boolean read,boolean favourite)
    		// ask the database manager to add a row given the two strings
    		/*for (int i=0;i<10;i++)
    		{
    			
	    		db.addRow_Movie
	    		("test"+String.valueOf(i),"Rev-test"+String.valueOf(i),(float) 0.0,"Link1-"+String.valueOf(i),"Link2-"+String.valueOf(i),"Link3-"+String.valueOf(i)
	    		);
    		}
    		for (int i=0;i<10;i++)
    		{
	    		db.addRow_Quote
	    		(i,"Description-Text"+String.valueOf(i),"false","false"
	    		);
    		}
    		for (int i=0;i<10;i++)
    		{
	    		db.addRow
	    		("Description-Text"+String.valueOf(i),"Second"
	    		);
    		}
    		*/
 
    	}
    	catch (Exception e)
    	{
    		Log.e("Add Error", e.toString());
    		e.printStackTrace();
    	}
    }
    
    private void LoadSampleQueries()
    {
    	try
    	{
    		db.addRow_Movie(1,"The Shawshank Redemption","Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",9.2,NULL,NULL,NULL);

    		db.addRow_Movie(2,"The Godfather","The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",9.2,NULL,NULL,NULL);
    		db.addRow_Movie(3,"The Godfather: Part II","The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on his crime syndicate stretching from Lake Tahoe, Nevada to pre-revolution 1958 Cuba.",9.0,NULL,NULL,NULL);
    		db.addRow_Movie(4,"The Good, the Bad and the Ugly","A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.",9.0,NULL,NULL,NULL);
    		db.addRow_Movie(5,"Pulp Fiction","The lives of two mob hit men, a boxer, a gangster^s wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",9.0,NULL,NULL,NULL);
    		db.addRow_Movie(6,"Cloudy with a Chance of Meatballs","Flint Lockwood thinks he^s a genius. But none of the things he invented are things that make sense or are useful. However, he has the support of his mother but when she dies, he^s left alone with his father who thinks he should give it up. When the community that he lives in, is in an economic crisis because their primary source of income a sardine cannery was shut down, Flint decides to try his latest invention, a machine that can turn water into food. But something goes wrong and the machine ends up in the atmosphere. Later it starts raining food. And so the shifty mayor tries to use this as a way to help their community. But when Flint sense something^s wrong with the machine, the mayor convinces him to ignore it. But as Flint predict chaos ensues.",7.1,NULL,NULL,NULL);
    		db.addRow_Movie(7,"Tangled","After receiving the healing powers from a magical flower, the baby Princess Rapunzel is kidnapped from the palace in the middle of the night by Mother Gothel. Mother Gothel knows that the flower^s magical powers are now growing within the golden hair of Rapunzel, and to stay young, she must lock Rapunzel in her hidden tower. Rapunzel is now a teenager and her hair has grown to a length of 70-feet. The beautiful Rapunzel has been in the tower her entire life, and she is curious of the outside world. One day, the bandit Flynn Ryder scales the tower and is taken captive by Rapunzel. Rapunzel strikes a deal with the charming thief to act as her guide to travel to the place where the floating lights come from that she has seen every year on her birthday. Rapunzel is about to have the most exciting and magnificent journey of her life.",8.0,NULL,NULL,NULL);
    		db.addRow_Movie(8,"Pirates of the Caribbean: The Curse of the Black Pearl","This swash-buckling tale follows the quest of Captain Jack Sparrow, a savvy pirate, and Will Turner, a resourceful blacksmith, as they search for Elizabeth Swann. Elizabeth, the daughter of the governor and the love of Will^s life, has been kidnapped by the feared Captain Barbossa. Little do they know, but the fierce and clever Barbossa has been cursed. He, along with his large crew, are under an ancient curse, doomed for eternity to neither live, nor die. That is, unless a blood sacrifice is made",8.0,NULL,NULL,NULL);
    		db.addRow_Movie(9,"Inception","Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb^s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible-inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.",8.9,NULL,NULL,NULL);
    		db.addRow_Movie(10,"The Rite","This films is essentially a newer version of the Exorcist with a little twist. It has its make-you-jump moments and some thrill throughout the film. This does provide the fright that a movie goer would look for in a horror type film. And the plot is not terrible. Anthony Hopkins brings his usually terror to this film. With all of that said, there were some slight set issues and mediocre acting and writing."+
    		"Overall, it is not as terrible as I expected. It does have the scary moments that you would like in a horror film, but I don^t think it will compare to any of the classic horror films. It shakes you up and puts you on the edge of your seat more than anything else. If you are a horror or fright film lover, check it out! Otherwise, I would call this film missable.",6.2,NULL,NULL,NULL);
    		db.addRow_Movie(11,"Black Swan","I was very lucky to snag tickets to see Black Swan at the the Toronto International Film Festival (TIFF.). Toronto^s gorgeous Elgin & Winter Garden Theatre was the perfect location to see such a stunning film."+ 
    		"THE GOOD: Natalie Portman^s acting was perfection - definitely an Oscar worthy performance. Mila Kunis^s performance was surprising in a good way, it is clear that she stepped out of her comfort zone. The film^s musical score was superb. Of course, much of it was taken from ^Swan Lake^, but I loved that they were able to incorporate that music throughout the entire film and not just in the ballet scenes. Of course, it was beautifully shot and the plot was riveting - I was drawn in from beginning to end. The audience saw a new side of ballet/ theatre that is not often shown in popular films - the struggle the performer faces in committing to and perfecting a role. The struggle between ^good^ vs. ^evil^ was presented in a methodical and intriguing way." 
    		+"THE BAD: while the film is labeled as being a ^psychological thriller^ I^ve got to say...many parts of it felt like it belonged in the horror Genre. While I am obviously still glad I watched it, some parts definitely made me jump or cringe (which I was not expecting). The ^psychological thriller^ aspect was still present, in that it was an emotional roller-coaster of a film. This ^emotional roller-coaster^ sort of dragged on to the point that it almost felt like it was too much. I just feel that it could have been tuned down a notch. "
    		+ "Overall, I thought that most of the film was wonderful, and I highly recommend it.",8.5,NULL,NULL,NULL);
    		db.addRow_Movie(12,"True Grit","Few directors working today in America have mastered form like the Coens, I discover this with every new film they make. True Grit is a commercial film made to please but I don^t see a compromise in the making and it^s still a distinctly Coen film if you pay notice. Try to take out the Coen character from the film and the film breaks apart, it^s that tightly woven in the fabric of it."
    		+ "A Coen film works for me in the face of it, but I^m always on the lookout for what goes on behind, for the unseen cogs that grind out the fates of their characters. As with No Country, I came to this film looking to see is there a statement on violence, does it happen in a certain way and is the universe indifferent to it, is life worth a damn?"
    		+ "This one here works very much like the Henry Hathaway film from ^69, except everyone^s better, where John Wayne played a character, Jeff Bridges plays a man, and even Barry Pepper betters my beloved Robert Duvall^s turn as Ned Pepper. This probably won^t do it for Jeff Bridges because we^ve been accustomed to expect a certain degree of po-faced seriousness from a great performance (he snarled and staggered in Crazy Heart but he was serious about it), but he^s one of the great actors of our times and I find this again in his Rooster Cogburn. Clint Eastwood also fell from a horse in Unforgiven and couldn^t shoot a tin can to save his soul, but Munny \"was\" a scumbag, Cogburn still is and I like that. I like the courtroom scene where it^s gradually revealed that he won^t only bushwack those he needs to bring to justice, he will lie to make himself out to be the hero."
    		+ "Another interesting aspect here is how the concept of the gunslinger and the western with it has evolved. When John Wayne played Cogburn in the Hathaway film the reward for the audience was the smirk of watching John Wayne be that drunken failure. The casting mattered in our appreciation. In the remake, most comments seem to point out that it^s a fairly traditional/entertaining western. The dastardly revisit of something that was revisionist in the 70^s oddly seems to give, in our day, a traditional western. We^ve been accustomed to heroes who are not heroes, and maybe that perversion of that heroic archetype says something about the way we view the world now, as opposed to 30 years ago. The next logical step from this is to see a Roy Rogers character played straight again, perhaps contrasted with a pitiless old West where violence is ordinary and life is meaningless."
    		+ "Is this then a traditional western? Watching True Grit through the eyes of the brass 14yo girl reminded me of Winter^s Bone, another film from the same year. In both cases a young girl is determined to plunge herself in a dark world of hurt and walk a path fraught with perils on all sides to achieve a moral purpose, both films maintain an appearance of realism, but what I get from them is a magical fantasy. This becomes more apparent when Mattie falls in the snakepit, but what about the hanged men who are really hanged high? The Hathaway film, ostensibly based on the same material, missed that note and played out a straight western. The Coen film unfolds as a hazy dream of that West. Although I wished for more open landscapes, it makes sense then that film narrows our gaze and clouds the margins. Perhaps we are even seeing the film as Mattie relives the experience in her old age, an affair shaped by memory and time."
    		+ "The epilogue is important in that aspect."
    		+ "It^s not only that Mattie^s revenge didn^t accomplish anything, that it was for her merely another practical inconvenience to be bargained, paid for, and settled, like her father^s ponies and saddle or the service of the US Marshall before, but that she clings to the memory of it so fiercely. What^s horrifying then is not so much the violence of the West but the idealization of that violence. The film closes in a time around the turn of the century, people like Cogburn roosted in Wild West shows for a cheering audience, and Mattie is one of the people who lived to tell the tales of the West. Out of those tales, the western of John Ford and Raoul Walsh emerged to print the legend. In a roundabout fantastic way, the Coens give us the true account, the creation myth behind the western.",8.1,NULL,NULL,NULL);
    		db.addRow_Movie(13,"The Tourist","(Synopsis) Elise (Angelina Jolie) randomly sits next to an American tourist, Frank (Johnny Depp), on a Venice-bound train. The police have been following Elise for over two years waiting for her to contact her lover, who embezzled over $2 Billion from a mobster. The British Economic Police want to collect its share (taxes) of over $775 Million to be paid on this money. Frank, a math teacher, and Elise must evade the police, and also the mobster who^s money was stolen."
    		+ "(My Comment) This movie is unlike many that Angelina Jolie has played in, in that she is involved in very little action. Johnny Depp has a few minor action scenes. Most of the time Angelina walks around looking beautiful, and Johnny is like a lost puppy, almost as if they phoned in their parts. It isn^t a totally bad movie; because it only has a little action and a poorly written dialogue for these talented actors. The storyline is not complicated; the mobster^s money man steals a large amount of his money, and he is now on the run for his life, plus the police want him too. The movie contains some beautiful panorama scenery of Venice. Overall, the movie is not what you would expect, but it kept my attention, and it is a little entertaining. By the way, there is a story twist that you may figure out for yourself before the end.",6.0,NULL,NULL,NULL);
    		db.addRow_Movie(14,"Platoon","A young recruit in Vietnam faces a moral crisis when confronted with the horrors of war and the duality of man.",8.2,NULL,NULL,NULL);
    		db.addRow_Movie(15,"Jarhead",NULL,7.2,NULL,NULL,NULL);
    		db.addRow_Movie(16,"Braveheart","William Wallace, a commoner, unites the 13th Century Scots in their battle to overthrow English rule.",8.4,NULL,NULL,NULL);
    		db.addRow_Movie(17,"The Boondock Saints",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(18,"Fargo","Jerry Lundegaard^s inept crime falls apart due to his and his henchmen^s bungling and the persistent police work of pregnant Marge Gunderson.",8.3,NULL,NULL,NULL);
    		db.addRow_Movie(19,"Saving Private Ryan","Following the Normandy Landings, a group of US soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.",8.5,NULL,NULL,NULL);
    		db.addRow_Movie(20,"The Pursuit of Happyness","A struggling salesman takes custody of his son as he^s poised to begin a life-changing professional endeavor.",7.8,NULL,NULL,NULL);
    		db.addRow_Movie(21,"500 Days of Summer",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(22,"The Sixth Sense",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(23,"Titanic",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(24,"Jerry Maquire",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(25,"Apollo 13",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(26,"Forrest Gump",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(27,"The Silence of the Lambs",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(28,"Terminator 2: Judgement Day",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(29,"Dead Poets Society",NULL,9.2,NULL,NULL,NULL);
    		
    		db.addRow_Movie(30,"Wall Street",NULL,4.2,NULL,NULL,NULL);

    		db.addRow_Movie(31,"Top Gun",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(32,"The Terminator",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(33,"Scarface",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(34,"Apocalypse Now",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(35,"Network",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(36,"Dirty Harry",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(37,"Love Story",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(38,"On the Waterfront",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(39,"A Streetcar Named Desire",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(40,"Gone with the Wind",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(41,"GoodFellas",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(42,"City Slickers",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(43,"Reservoir Dogs",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(44,"Unforgiven",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(45,"The Mask",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(46,"Se7en",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(47,"The Usual Suspects",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(48,"The Big Lebowski",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(49,"The Truman Show",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(50,"The Fight Club",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(51,"Star Wars - Episode I: The Phantom Menace",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(52,"Gladiator",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(53,"A Beautiful Mind",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(54,"The Lord of the Rings: The Two Towers",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(55,"The Dark Knight",NULL,0.0,NULL,NULL,NULL);
    		db.addRow_Movie(56,"Tropic Thunder",NULL,0.0,NULL,NULL,NULL);


    		db.addRow_Quote(1,1,"That tall drink of water with the silver spoon up his ass.",0,1);
    		db.addRow_Quote(2,1,"I believe in two things: discipline and the Bible. Here you' ll receive both. Put your trust in the Lord; your ass belongs to me.",0,1);
    		db.addRow_Quote(3,1,"If I hear so much as a mouse fart in here the rest of the night I swear by God and sonny Jesus you will all visit the infirmary.",0,0);
    		db.addRow_Quote(4,1,"What is your malfunction, you fat barrel of monkey spunk?",0,0);
    		db.addRow_Quote(5,1,"Let me tell you something my friend. Hope is a dangerous thing. Hope can drive a man insane.",0,0);
    		db.addRow_Quote(6,1,"... there are places in this world that aren^t made out of stone. That there^s something inside... that they can^t get to, that they can^t touch. That^s yours.",0,0);
    		db.addRow_Quote(7,1,"I want him found. Not tomorrow, not after breakfast - *now*.",0,0);
    		db.addRow_Quote(8,1,"The funny thing is - on the outside, I was an honest man, straight as an arrow. I had to come to prison to be a crook.",0,0);
    		db.addRow_Quote(9,1,"Andy Dufresne - who crawled through a river of shit and came out clean on the other side.",0,0);
    		db.addRow_Quote(10,1,"We sat and drank with the sun on our shoulders and felt like free men. Hell, we could have been tarring the roof of one of our own houses. We were the lords of all creation",0,0);
    		db.addRow_Quote(11,1,"You could argue he^d done it to curry favor with the guards. Or, maybe make a few friends among us cons. Me, I think he did it just to feel normal again, if only for a short while.",0,0);
    		db.addRow_Quote(12,1,"Lord! It^s a miracle! Man up and vanished like a fart in the wind!",0,0);
    		db.addRow_Quote(13,1,"Get busy living, or get busy dying.",0,0);
    		db.addRow_Quote(14,1,"You eat when we say you eat. You shit when we say you shit. You piss when we say you piss. You got that, you maggot dick motherfucker?",0,0);
    		db.addRow_Quote(15,1,"One day, when I have a long gray beard and two or three marbles rollin^ around upstairs, they^ll let me out.",0,0);
    		db.addRow_Quote(16,1,"I was in the path of the tornado... I just didn^t expect the storm would last as long as it has.",0,0);
    		db.addRow_Quote(17,1,"I understand you^re a man who knows how to get things.",0,0);
    		db.addRow_Quote(18,2,"My credit good enough to buy you out?",0,0);
    		db.addRow_Quote(19,2,"What^s the matter with you? I think your brain is going soft with all that comedy you are playing with that young girl. Never tell anyone outside the Family what you are thinking again.",0,0);
    		db.addRow_Quote(20,2,"You straightened my brother out?",0,0);
    		db.addRow_Quote(21,2,"I^ll make him an offer he can^t refuse.",0,0);
    		db.addRow_Quote(22,2,"Goddamn FBI don^t respect nothin^.",0,0);
    		db.addRow_Quote(23,2,"In Sicily, women are more dangerous than shotguns.",0,0);
    		db.addRow_Quote(24,2,"My father is no different than any powerful man, any man with power, like a president or senator.",0,0);
    		db.addRow_Quote(25,2,"Now you listen to me, you smooth-talking son-of-a-bitch, let me lay it on the line for you and your boss, whoever he is! Johnny Fontane will never get that movie! I don^t care how many dago guinea wop greaseball goombahs come out of the woodwork!",0,0);
    		db.addRow_Quote(26,2,"Tom-anuch! Hey, a hundred button men on the street twenty-four hours a day. That Turk shows one hair on his ass and he^s dead.",0,0);
    		db.addRow_Quote(27,2,"Where does it say that you can^t kill a cop?",0,0);
    		db.addRow_Quote(28,2,"Luca Brasi sleeps with the fishes.",0,0);
    		db.addRow_Quote(29,2,"You talk about vengeance. Is vengeance going to bring your son back to you? Or my boy to me?",0,0);
    		db.addRow_Quote(30,2,"... a man who doesn^t spend time with his family can never be a real man.",0,0);
    		db.addRow_Quote(31,2,"Some people will pay a lot of money for that information; but then your daughter would lose a father, instead of gaining a husband.",0,0);
    		db.addRow_Quote(32,2,"I don^t like violence, Tom. I^m a businessman; blood is a big expense.",0,0);
    		db.addRow_Quote(33,3,"I don^t feel I have to wipe everybody out, Tom. Just my enemies.",0,0);
    		db.addRow_Quote(34,3,"There are many things my father taught me here in this room. He taught me: keep your friends close, but your enemies closer.",0,0);
    		db.addRow_Quote(35,3,"I make him an offer he don^ refuse. Don^ worry.",0,0);
    		db.addRow_Quote(36,3,"If anything in this life is certain, if history has taught us anything, it is that you can kill anyone.",0,0);
    		db.addRow_Quote(37,3,"This is the business we^ve chosen.",0,0);
    		db.addRow_Quote(38,3,"When a plot against the Emperor failed... the plotters were always given a chance... to let their families keep their fortunes.",0,0);
    		db.addRow_Quote(39,3,"I^d give four million just to be able to take a piss without it hurting",0,1);
    		db.addRow_Quote(40,3,"I^m going to take a nap. When I wake up, if the money is on the table, I^ll know I have a partner. If it isn^t, I^ll know I don^t.",0,0);
    		db.addRow_Quote(41,3,"Good health is the most important thing. More than success, more than money, more than power.",0,0);
    		db.addRow_Quote(42,3,"Your country ain^t your blood. Remember that.",0,0);
    		db.addRow_Quote(43,3,"Every time I put the line in the water I said a Hail Mary and every time I said a Hail Mary I caught a fish.",0,0);
    		db.addRow_Quote(44,4,"I^ve never seen so many men wasted so badly.",0,0);
    		db.addRow_Quote(45,4,"Oh I almost forgot. He payed me a thousand. I think his idea was that I kill you.",0,0);
    		db.addRow_Quote(46,4,"If you save your breath I feel a man like you can manage it. And if you don^t manage it, you^ll die. Only slowly, very slowly old friend.",0,0);
    		db.addRow_Quote(47,4,"There are two kinds of people in the world, my friend: Those with a rope around the neck, and the people who have the job of doing the cutting.",0,0);
    		db.addRow_Quote(48,4,"t^s not a joke, it^s a rope, Tuco. Now I want you to get up there and put your head in that noose.",0,0);
    		db.addRow_Quote(49,4,"You smell like a pig already. Let^s try not to make things any worse.",0,0);
    		db.addRow_Quote(50,4,"You see, in this world there^s two kinds of people, my friend: Those with loaded guns and those who dig. You dig.",0,0);
    		db.addRow_Quote(51,4,"When you have to shoot, shoot. Don^t talk.",0,0);
    		db.addRow_Quote(52,4,"You became a priest because you were too much of a coward to do what I do.",0,0);
    		db.addRow_Quote(53,4,"The way I figure, there^s really not too much future with a sawed-off runt like you",0,0);
    		db.addRow_Quote(54,4,"Get on that stool and put the rope around your neck. I have a different system, my friend; I don^t shoot the rope, I shoot the legs from under the stool.",0,0);
    		db.addRow_Quote(55,4,"Every gun makes its own tune.",0,0);
    		db.addRow_Quote(56,4,"One bastard goes in, another one comes out.",0,0);
    		db.addRow_Quote(57,4,"You never had a rope around your neck. Well, I^m going to tell you something. When that rope starts to pull tight, you can feel the Devil bite your ass.",0,0);
    		db.addRow_Quote(58,4,"There are two kinds of spurs, my friend. Those that come in by the door; those that come in by the window.",0,0);
    		db.addRow_Quote(59,4,"Whoever has the most liquor to get the soldiers drunk and send them to be slaughtered... he^s the winner.",0,0);
    		db.addRow_Quote(60,4,"Even a filthy beggar like that has got a protecting angel.",0,0);
    		db.addRow_Quote(61,4,"If your friends stay out in the damp, they^re liable to catch a cold aren^t they... or a bullet.",0,0);
    		db.addRow_Quote(62,4,"I^m looking for the owner of that horse. He^s tall, blonde, he smokes a cigar, and he^s a pig!",0,0);
    		db.addRow_Quote(63,4,"I like big fat men like you. When they fall they make more noise. And sometimes they don^t get up.",0,0);
    		db.addRow_Quote(64,5,"In the fifth, your ass goes down. Say it.",0,0);
    		db.addRow_Quote(65,5,"That^s thirty minutes away. I^ll be there in ten.",0,0);
    		db.addRow_Quote(66,5,"I^m gonna get fuckin^ divorced. No marriage counselling, no trial separation, I^m gonna get fuckin^ divorced.",0,0);
    		db.addRow_Quote(67,5,"I^m Winston Wolfe. I solve problems.",0,0);
    		db.addRow_Quote(68,5,"ou see, this profession is filled to the brim with unrealistic motherfuckers. Motherfuckers who thought their ass would age like wine. If you mean it turns to vinegar, it does. If you mean it gets better with age, it don^t.",0,0);
    		db.addRow_Quote(69,5,"You feel that sting, big boy, huh? That^s pride FUCKIN^ with you! You gotta fight through that shit!",0,0);
    		db.addRow_Quote(70,5,"Knucklehead walks into a bank with a telephone! Not a pistol, not a shotgun, but a fucking phone. Cleans the place out, doesn^t even lift a fucking finger.",0,0);
    		db.addRow_Quote(71,5,"Correctamundo. And that^s what we^re gonna be. We^re gonna be cool.",0,0);
    		db.addRow_Quote(72,5,"I got a threshold, Jules. I got a threshold for the abuse that I will take. Now, right now, I^m a fuckin^ race car, right, and you got me the red. And I^m just sayin^, I^m just sayin^ that it^s fuckin^ dangerous to have a race car in the fuckin^ red. That^s all. I could blow.",0,0);
    		db.addRow_Quote(73,5,"The night of the fight, you may feel a slight sting. That^s pride fucking with you. Fuck pride. Pride only hurts, it never helps.",0,0);
    		db.addRow_Quote(74,5,"Uncomfortable silences. Why do we feel it^s necessary to yak about bullshit in order to be comfortable?",0,0);
    		db.addRow_Quote(75,5,"I^m prepared to scour the the Earth for that motherfucker. If Butch goes to Indochina, I want a nigger waiting in a bowl of rice ready to pop a cap in his ass.",0,0);
    		db.addRow_Quote(76,5,"I don^t wanna hear about no motherfuckin^ ifs. All I wanna hear from your ass is, You ain^t got no problem, Jules.",0,0);
    		db.addRow_Quote(77,5,"You ain^t got no problem, Jules. I^m on the motherfucker. Go back in there, chill them niggers out and wait for the Wolf who should be coming directly.",0,0);
    		db.addRow_Quote(78,5,"Get it straight buster - I^m not here to say please, I^m here to tell you what to do and if self-preservation is an instinct you possess you^d better fucking do it and do it quick.",0,0);
    		db.addRow_Quote(79,5,"Jules, if you give that fuckin^ nimrod fifteen hundred dollars, I^m gonna shoot him on general principles.",0,0);
    		db.addRow_Quote(80,5,"If my answers frighten you then you should cease asking scary questions.",0,0);
    		db.addRow_Quote(81,5,"You see that, young lady? Respect. Respect for one^s elders gives character.",0,0);
    		db.addRow_Quote(82,5,"Fuck! Motherfucking shit! Do you fucking know how fucking stupid you are? Shit! Fuck!",0,0);
    		db.addRow_Quote(83,5,"Am I a nigger? Are we in Inglewood? No... You^re in my home. White people who know the difference between good shit and bad shit, this is the house they come to. Now, my shit, I^ll take the Pepsi challenge with that Amsterdam shit, any day of the fuckin^ week.",0,0);
    		db.addRow_Quote(84,5,"Honey, since I left you, this has been without a doubt the single weirdest fucking day of my life! Come on, hop on - I^ll tell you all about it.",0,0);
    		db.addRow_Quote(85,5,"Three tomatoes are walking down the street- a poppa tomato, a momma tomato, and a little baby tomato. Baby tomato starts lagging behind. Poppa tomato gets angry, goes over to the baby tomato, and smooshes him... and says, Catch up.",0,0);
    		db.addRow_Quote(86,5,"Shut up, Fatso! I don^t have a pot! I have a bit of a tummy, like Madonna when she did \"Lucky Star,\" it^s not the same thing.",0,0);
    		db.addRow_Quote(87,5,"Bitch, be cool!",0,0);
    		db.addRow_Quote(88,5,"Nobody kills anyone in my store except me and Zed.",0,0);
    		db.addRow_Quote(89,6,"[running while carrying a pair of giant scissors] I shouldn^t be running with these!",0,0);
    		db.addRow_Quote(90,6,"I^m not Baby Brent anymore. I am Chicken Brent! And I^m finally contributing to society!",0,0);
    		db.addRow_Quote(91,6,"You may have seen a meteor shower, but I bet you^ve never seen a shower \"meatier\" than this.",0,0);
    		db.addRow_Quote(92,6,"What a nerd! You^re trying to be smart, and that^s lame!",0,0);
    		db.addRow_Quote(93,6,"I know we all blame Flint for this. In fact, the minute he steps out of that car, I^m gonna slap him in the face! He made a mess of things, but that mess was made to order, and it^s time we pay the bill.",0,0);
    		db.addRow_Quote(94,6,"My chest hairs are tingling! Something^s wrong.",0,0);
    		db.addRow_Quote(95,6,"I wanted to run away that day, but you can^t run away from your own feet.",0,0);
    		db.addRow_Quote(96,6,"Have you ever felt like you were a little bit different? Like you had something unique to offer the world, if you could just get people to see it. Then you know exactly how it felt to be me.",0,0);
    		db.addRow_Quote(97,7,"You smell that? Take a deep breath through the nose. [Breathes through nose]. Really let that seep in. What are you getting? Because to me, that^s part man-smell, and the other part is really bad man-smell. I don^t know why, but overall it just smells like the color brown. Your thoughts?",0,0);
    		db.addRow_Quote(98,7,"I could get used to a view like this. Yep, I^m used to it. Guys I want a castle.",0,0);
    		db.addRow_Quote(99,7,"Let^s just assume for the moment that everyone in here doesn^t like me!",0,0);
    		db.addRow_Quote(100,7,"Your dream stinks. I was talking to her.",0,0);
    		db.addRow_Quote(101,7,"Rapunzel, please, stop with the mumbling. You know how I feel about the mumbling. Blah blah blah blah, it^s very annoying! I^m just teasing, you^re adorable. I love you so much, darling.",0,0);
    		db.addRow_Quote(102,7,"You broke my smolder!",0,0);
    		db.addRow_Quote(103,7,"The party lasted an entire week, and honestly, I don^t remember most of it.",0,0);
    		db.addRow_Quote(104,7,"Have some humanity. Hasn^t any of you had a dream?",0,0);
    		db.addRow_Quote(105,7,"That^s a lot of hair.",0,0);
    		db.addRow_Quote(106,7,"Goldie look at this. Good sir that^s a lot of blood!",0,0);
    		db.addRow_Quote(107,7,"I can^t believe I did this. *I can^t believe I did this!* Mother would be so furious. That^s OK though, I mean what she doesn^t know won^t kill her. Oh my gosh. This would kill her. *This is so fun!* I, am a horrible daughter. I^m going back. *I am never going back!* I am a despicable human being. *Woo-hoo! Best. Day. Ever!*",0,0);
    		db.addRow_Quote(108,7,"Does your mother deserve it? No. Would this break her heart and crush her soul? Of course, but you just got to do it.",0,0);
    		db.addRow_Quote(109,7,"No! Listen, the only thing I want to do with your hair is to get out of it... literally!",0,0);
    		db.addRow_Quote(110,7,"Did I ever tell you I^ve got a thing for brunettes?",0,0);
    		db.addRow_Quote(111,7,"[a cute little bunny hops out of the bushes] Stay calm. It can probably smell fear.",0,0);
    		db.addRow_Quote(112,7,"Here^s your pan, here^s your frog.",0,0);
    		db.addRow_Quote(113,7,"Ha! You should see your faces because you look -",0,0);
    		db.addRow_Quote(114,7,"[crashes into a beam]... ridiculous.",0,0);
    		db.addRow_Quote(115,8,"First, your return to shore was not part of our negotiations nor our agreement so I must do nothing. And secondly, you must be a pirate for the pirate^s code to apply and you^re not. And thirdly, the code is more what you^d call \"guidelines\" than actual rules. Welcome aboard the Black Pearl, Miss Turner.",0,0);
    		db.addRow_Quote(116,8,"Apparently there^s some sort of high-toned and fancy to-do up at the fort, eh? How could it be that two upstanding gentlemen, such as yourselves, did not merit an invitation?",0,0);
    		db.addRow_Quote(117,8,"Parlay. I invoke the right of parlay. According to the Code of the brethren, set down by the pirates Morgan and Bartholomew , you have to take me to your Captain.",0,0);
    		db.addRow_Quote(118,8,"Don^t dare impugn me honor, boy! I agreed she go free, but it was you who failed to specify when or where. Though it does seem a shame to lose somethin^ so fine, don^t it, lads?",0,0);
    		db.addRow_Quote(119,8,"So I^ll be havin^ that dress back before ye go.",0,0);
    		db.addRow_Quote(120,8,"Jack... Jack! Did you not notice? That be the same island we made you the governor of on our last little trip.",0,0);
    		db.addRow_Quote(121,8,"Seeing as there^s two of us, a gentleman would give us a pair of pistols.",0,0);
    		db.addRow_Quote(122,8,"It^ll be one pistol as before, and you can be the gentleman and shoot the lady; and starve to death yourself.",0,0);
    		db.addRow_Quote(123,8,"Jack Sparrow ...for your willful commission of crime against the crown. Those crimes being numerous in quantity and sinister in nature...  ...impersonating an officer of the Royal Navy; impersonating a clergy of the Church of England...  ...arson; kidnapping; perjury; piracy; pilfering; deprivation of a Federal Loyalist. For these crimes you will be hung by the neck until dead. May God have mercy on your soul.",0,0);
    		db.addRow_Quote(124,8,"The only rules that really matter are these: what a man can do and what a man can^t do. For instance, you can accept that your father was a pirate and a good man or you can^t. But pirate is in your blood, boy, so you^ll have to square with that some day. And me, for example, I can let you drown, but I can^t bring this ship into Tortuga all by me onesies, savvy? So, can you sail under the command of a pirate, or can you not?",0,0);
    		db.addRow_Quote(125,9,"I^ve come back for you, to remind you of something. Something you once knew. That this world is not real.",0,0);
    		db.addRow_Quote(126,9,"Dare you take a leap of faith? Or become an old man, filled with regret, waiting to die alone?",0,0);
    		db.addRow_Quote(127,9,"Cobb? Impossible... We were young men together. I^m an old man.",0,0);
    		db.addRow_Quote(128,9,"Dreams feel real while we^re in them. It^s only when we wake up that we realize something was actually strange.",0,0);
    		db.addRow_Quote(129,9,"You mustn^t be afraid to dream a little bigger, darling. [Pulls out a grenade launcher]",0,0);
    		db.addRow_Quote(130,9,"I can access your mind through your dreams.",0,0);
    		db.addRow_Quote(131,9,"The seed that we planted in this man^s mind may change everything.",0,0);
    		db.addRow_Quote(132,9,"You^re asking me for Inception. I hope you do understand the gravity of that request.",0,0);
    		db.addRow_Quote(133,9,"That many dreams within dreams is too unstable!",0,0);
    		db.addRow_Quote(134,9,"If we are gonna perform Inception then we need imagination.",0,0);
    		db.addRow_Quote(135,9,"I know how to find secrets from your Mind, I know all the tricks!",0,0);
    		db.addRow_Quote(136,9,"I think positive emotion trumps negative emotion every time.",0,0);
    		db.addRow_Quote(137,9,"I^ll tell you a riddle. You^re waiting for a train, a train that will take you far away. You know where you hope this train will take you, but you don^t know for sure. But it doesn^t matter. How can it not matter to you where that train will take you?",0,0);
    		db.addRow_Quote(138,9,"You keep telling yourself what you know. But what do you believe? What do you feel?",0,0);
    		db.addRow_Quote(139,9,"You remind me of someone... a man I met in a half-remembered dream. He was possessed of some radical notions.",0,0);
    		db.addRow_Quote(140,9,"Do you know what it is to be a lover? Half of a whole?",0,0);
    		db.addRow_Quote(141,9,"[Confused] Wait, whose subconscious are we going through exactly?",0,0);
    		db.addRow_Quote(142,9,"She locked away a secret, deep inside herself, something she once knew to be true... but chose to forget.",0,0);
    		db.addRow_Quote(143,10,"choosing not to believe in the devil doesn^t protect you from him^",0,0);
    		db.addRow_Quote(144,11,"That was me seducing you. It needs to be the other way around.",0,0);
    		db.addRow_Quote(145,12,"[LaBoeuf has been talking about malum prohibitum and malum in se] It astonishes me that Mr. LaBoeuf has been shot, trampled, and nearly bitten his tongue off, and yet not only does he continue to talk but he spills the banks of English.",0,0);
    		db.addRow_Quote(146,13,"Bongiorno!^",0,0);
    		db.addRow_Quote(147,13,"Bon Jovi!^",0,0);
    		db.addRow_Quote(148,14,"All right, you cheese-dicks, welcome to the ^nam! Follow me.",0,0);
    		db.addRow_Quote(149,15,"A man fires a rifle for many years, and he goes to war. And afterward he turns the rifle in at the armory, and he believes he^s finished with the rifle. But no matter what else he might do with his hands, love a woman, build a house, change his son^s diaper; his hands remember the rifle.",0,0);
    		db.addRow_Quote(150,16,"It^s all for nothing if you don^t have freedom.",0,0);
    		db.addRow_Quote(151,16,"Are you ready for a war?",0,0);
    		db.addRow_Quote(152,16,"Not the archers. My scouts tell me their archers are miles away and no threat to us. Arrows cost money. Use up the Irish. The dead cost nothing.",0,0);
    		db.addRow_Quote(153,16,"The Almighty says this must be a fashionable fight. It^s drawn the finest people.",0,0);
    		db.addRow_Quote(154,16,"Lower your flags and march straight back to England, stopping at every home you pass by to beg forgiveness for a hundred years of theft, rape, and murder. Do that and your men shall live. Do it not, and every one of you will die today.",0,0);
    		db.addRow_Quote(155,16,"You have bled with Wallace, now bleed with me.",0,0);
    		db.addRow_Quote(156,16,"Before we let you leave, your commander must cross that field, present himself before this army, put his head between his legs, and kiss his own arse.",0,0);
    		db.addRow_Quote(157,16,"They fought like warrior poets; they fought like Scotsmen, and won their freedom.",0,0);
    		db.addRow_Quote(158,16,"I hope you^ve washed your ass this morning, it^s about to be kissed by a king.",0,0);
    		db.addRow_Quote(159,16,"The trouble with Scotland is that it^s full of Scots.",0,0);
    		db.addRow_Quote(160,16,"Every man dies, not every man really lives.",0,0);
    		db.addRow_Quote(161,16,"We all end up dead, it^s just a question of how and why.",0,0);
    		db.addRow_Quote(162,17,"Doc, I gotta buy you, like, a proverb book or something. This mix^n^match shit^s gotta go",0,0);
    		db.addRow_Quote(163,17,"You know what they say: People in glass houses sink sh-sh-ships.",0,0);
    		db.addRow_Quote(164,17,"He left me his c-c-c... He left me his c-c-c... Oh, he fucking gave me this. Fuck! Ass!",0,0);
    		db.addRow_Quote(165,17,"We^re sorta like 7-Eleven. We^re not always doing business, but we^re always open.",0,0);
    		db.addRow_Quote(166,17,"Hey fuck-ass, give me a beer.",0,0);
    		db.addRow_Quote(167,17,"Whosoever shed man^s blood, by man shall his blood be shed.",0,0);
    		db.addRow_Quote(168,17,"They can suck my pathetic little dick, and I^ll dip my nuts in marinara sauce just so the fat bastards can get a taste of home while they^re at it.",0,0);
    		db.addRow_Quote(169,17,"He^s happy now, just killing us one by one. And worse, he^s good at it.",0,0);
    		db.addRow_Quote(170,17,"This guy takes out a whole family... wife, kids, everyone... like he^s ordering fucking pizza.",0,0);
    		db.addRow_Quote(171,17,"So you^re telling me it was one guy with six guns, and he was a senior frigging citizen?",0,0);
    		db.addRow_Quote(172,17,"The question is not how far. The question is, do you possess the constitution, the depth of faith, to go as far is as needed?",0,0);
    		db.addRow_Quote(173,17,"Never shall innocent blood be shed, yet the blood of the wicked shall flow like a rive.",0,0);
    		db.addRow_Quote(174,17,"Television. Television is the explanation for this - you see this in bad television. Little assault guys creeping through the vents, coming in through the ceiling - that James Bond shit never happens in real life! Professionals don^t do that!",0,0);
    		db.addRow_Quote(175,17,"So Duffy, you got any theories to go with that... tie?",0,0);
    		db.addRow_Quote(176,17,"Fuckin^- What the fuckin^. Fuck. Who the fuck fucked this fucking... How did you two fucking fucks...",0,0);
    		db.addRow_Quote(177,17,"Just pour the drink, you fairy fuck.",0,0);
    		db.addRow_Quote(178,18,"You^re a smooth smoothie, you know?",0,0);
    		db.addRow_Quote(179,18,"Just keep it still back there, lady, or we^re going to have to, you know, shoot you.",0,0);
    		db.addRow_Quote(180,19,"We^re not here to do the decent thing, we^re here to follow fucking orders!",0,0);
    		db.addRow_Quote(181,19,"You don^t know when to shut up; you don^t know HOW to shut up!",0,0);
    		db.addRow_Quote(182,19,"It^s like finding a needle in a stack of needles.",0,0);
    		db.addRow_Quote(183,19,"I just know that every man I kill, the farther away from home I feel.",0,0);
    		db.addRow_Quote(184,19,"Hey, Upham, careful you don^t step in the bullshit!",0,0);
    		db.addRow_Quote(185,19,"Fucked up beyond all recognition.",0,0);
    		db.addRow_Quote(186,20,"Hey. Don^t ever let somebody tell you... You can^t do something. Not even me. All right?",0,0);
    		db.addRow_Quote(187,20,"You got a dream... You gotta protect it. People can^t do somethin^ themselves, they wanna tell you you can^t do it. If you want somethin^, go get it. Period.",0,0);
    		db.addRow_Quote(188,21,"Either she^s an evil, emotionless, miserable human being, or... she^s a robot.",0,0);
    		db.addRow_Quote(189,22,"I see dead people.",0,0);
    		db.addRow_Quote(190,23,"I^m king of the world!",0,0);
    		db.addRow_Quote(191,24,"Show me the money!",0,0);
    		db.addRow_Quote(192,25,"Houston, we have a problem.",0,0);
    		db.addRow_Quote(193,26,"Mama always said life was like a box of chocolates. You never know what you^re gonna get.",0,0);
    		db.addRow_Quote(194,26,"And cause I was a gazillionaire, and I liked doin it so much, I cut that grass for free.",0,0);
    		db.addRow_Quote(195,26,"Now you wouldn^t believe me if I told you, but I could run like the wind blows. From that day on, if I was ever going somewhere, I was running!",0,0);
    		db.addRow_Quote(196,26,"Stupid is as stupid does",0,0);
    		db.addRow_Quote(197,26,"When I got tired, I slept. When I got hungry, I ate. When I had to go, you know, I went.",0,0);
    		db.addRow_Quote(198,26,"We was always taking long walks, and we was always looking for a guy named \"Charlie\".",0,0);
    		db.addRow_Quote(199,26,"One day it started raining, and it didn^t quit for four months. We been through every kind of rain there is. Little bitty stingin^ rain... and big ol^ fat rain. Rain that flew in sideways. And sometimes rain even seemed to come straight up from underneath. Shoot, it even rained at night...",0,0);
    		db.addRow_Quote(200,27,"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.",0,0);
    		db.addRow_Quote(201,28,"Hasta la vista, baby.",0,0);
    		db.addRow_Quote(202,29,"Carpe diem. Seize the day, boys. Make your lives extraordinary",0,0);
    		db.addRow_Quote(203,30,"Greed, for lack of a better word, is good.",0,0);
    		db.addRow_Quote(204,31,"I feel the need—the need for speed!",0,0);
    		db.addRow_Quote(205,32,"I^ll be back.",0,0);
    		db.addRow_Quote(206,33,"Don^t get high on your own supply.",0,0);
    		db.addRow_Quote(207,33,"I^m Tony Montana! You fuck with me, you fuckin^ with the best!",0,0);
    		db.addRow_Quote(208,33,"You wanna fuck with me? Okay. You wanna play rough? Okay. Say hello to my little friend!",0,0);
    		db.addRow_Quote(209,33,"Say hello to my little friend!",0,0);
    		db.addRow_Quote(210,33,"In this country, you gotta make the money first. Then when you get the money, you get the power. Then when you get the power, then you get the women.",0,0);
    		db.addRow_Quote(211,33,"I never fucked anybody over in my life didn^t have it coming to them.",0,0);
    		db.addRow_Quote(212,33,"You know what capitalism is? Getting fucked!",0,0);
    		db.addRow_Quote(213,33,"This is paradise, I^m tellin^ ya. This town like a great big pussy just waiting to get fucked.",0,0);
    		db.addRow_Quote(214,33,"You think you can take me? You need a fucking army if you gonna take me!",0,0);
    		db.addRow_Quote(215,33,"The only thing in this world that gives orders... is balls.",0,0);
    		db.addRow_Quote(216,33,"Chi Chi, get the yeyo.",0,0);
    		db.addRow_Quote(217,33,"The World Is Yours!",0,0);
    		db.addRow_Quote(218,33,"Go ahead! I take your fucking bullets! You think you kill me with bullets? I take your fucking bullets! Go ahead!",0,0);
    		db.addRow_Quote(219,34,"I love the smell of napalm in the morning!",0,0);
    		db.addRow_Quote(220,35,"I^m as mad as hell, and I^m not going to take this anymore!",0,0);
    		db.addRow_Quote(221,36,"You^ve got to ask yourself one question: ^Do I feel lucky?^ Well, do ya, punk?",0,0);
    		db.addRow_Quote(222,37,"Love means never having to say you^re sorry.",0,0);
    		db.addRow_Quote(223,38,"You don^t understand! I coulda had class. I coulda been a contender. I could^ve been somebody, instead of a bum, which is what I am.",0,0);
    		db.addRow_Quote(224,39,"I have always depended on the kindness of strangers.",0,0);
    		db.addRow_Quote(225,40,"Frankly, my dear, I don^t give a damn.",0,0);
    		db.addRow_Quote(226,41,"As far back as I can remember, I always wanted to be a gangster.",0,0);
    		db.addRow_Quote(227,41,"What do you mean, I^m funny?...You mean the way I talk? What?...Funny how? I mean, what^s funny about it?...But I^m funny how? I mean, funny like I^m a clown? I amuse you? I make you laugh? I^m here to f--kin^ amuse you? What do you mean, funny? Funny how? How^m I funny??...How the f--k am I funny? What the f--k is so funny about me? Tell me? Tell me what^s funny!...",0,0);
    		db.addRow_Quote(228,41,"Right after I got here, I ordered some spaghetti with marinara sauce and I got egg noodles and ketchup. I^m an average nobody. I get to live the rest of my life like a schnook",0,0);
    		db.addRow_Quote(229,42,"Hi, Curly, kill anyone today?",0,0);
    		db.addRow_Quote(230,42,"I crap bigger than you!",0,0);
    		db.addRow_Quote(231,42,"Did you ever reach a point in your life, where you say to yourself: ^This is the best I^m ever going to look, the best I^m ever going to feel, the best I^m ever going to do,^ and it ain^t that great?",0,0);
    		db.addRow_Quote(232,27,"Well, Clarice, have the lambs stopped screaming?",0,0);
    		db.addRow_Quote(233,27,"Tell me, Senator: did you nurse Catherine yourself?...Did you breast-feed her?...Toughened your nipples, didn^t it?...Amputate a man^s leg and he can still feel it tickling. Tell me, mum, when your little girl is on the slab, where will it tickle you?...Oh, and Senator, just one more thing. Love your suit!",0,0);
    		db.addRow_Quote(234,27,"I do wish we could chat longer, but I^m having an old friend for dinner. Bye.",0,0);
    		db.addRow_Quote(235,43,"All right, ramblers, let^s get ramblin^.",0,0);
    		db.addRow_Quote(236,43,"Here are your names: Mr. Brown, Mr. White, Mr. Blonde, Mr. Blue, Mr. Orange, and Mr. Pink.",0,0);
    		db.addRow_Quote(237,44,"It^s a hell of a thing, killin^ a man. You take away all he^s got and all he^s ever gonna have.",0,0);
    		db.addRow_Quote(238,45,"Oooh! Somebody stop me!",0,0);
    		db.addRow_Quote(239,46,"Ernest Hemingway once wrote: ^The world is a fine place and worth fighting for.^ I agree with the second part.",0,0);
    		db.addRow_Quote(240,47,"The greatest trick the devil ever pulled was convincing the world he didn^t exist. And like that - he^s gone.",0,0);
    		db.addRow_Quote(241,48,"You got the wrong guy. I^m the Dude, man.",0,0);
    		db.addRow_Quote(242,48,"I^m the Dude! So that^s what you call me. You know, uh, that or, uh, His Dudeness, or uh, Duder, or uh, you know, El Duderino - if you^re not into the whole brevity thing.",0,0);
    		db.addRow_Quote(243,49,"Good morning...Oh, and in case I don^t see ya, good afternoon, good evening, and good night!",0,0);
    		db.addRow_Quote(244,50,"It^s only after we^ve lost everything that we^re free to do anything",0,0);
    		db.addRow_Quote(245,51,"Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering. I sense much fear in you",0,0);
    		db.addRow_Quote(246,52,"What we do in life echoes in eternity.",0,0);
    		db.addRow_Quote(247,52,"At my signal, unleash hell.",0,0);
    		db.addRow_Quote(248,52,"...Father to a murdered son. Husband to a murdered wife. And I will have my vengeance, in this life or the next.",0,0);
    		db.addRow_Quote(249,52,"Are you not entertained! Are you not entertained! Is this not why you are here!",0,0);
    		db.addRow_Quote(250,53,"Find a truly original idea. It is the only way I will ever distinguish myself. It is the only way I will ever matter.",0,0);
    		db.addRow_Quote(251,54,"My precious.",0,0);
    		db.addRow_Quote(252,55,"Want to know how I got these scars? My father was a drinker and a fiend. And one night, he goes off crazier than usual. Mommy gets the kitchen knife to defend herself. He doesn^t like that. Not one bit. So, me watching, he takes the knife to her, laughing while he does it. He turns to me, and he says: ^Why so serious?^ He comes at me with the knife - ^Why so serious?!^ He sticks the blade in my mouth. ^Let^s put a smile on that face!^ And why so serious?",0,0);
    		db.addRow_Quote(253,56,"I know who I am! I^m a dude playing a dude disguised as another dude!",0,0);
    	}
    	catch (Exception e)
    	{
    		Log.e("Add Error", e.toString());
    		e.printStackTrace();
    	}
    
    }

}
