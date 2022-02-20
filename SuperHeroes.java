/* 
* Creating classes to learn a bit about java
*/ 

/* Super hero classes */

class Hero {

        private Costume  hero_cs  ;
        private Power  hero_pwr;
        private int alive ;

        /* Create the hero */
        Hero() {

        this.hero_cs = new Costume() ;
        this.hero_pwr = new Power() ;
        this.alive = 1 ; // The hero lives
        }


        public void changeCostume (Costume hero_cs ) {
        /* Change the costume here */
        this.hero_cs = hero_cs ;

         }

        public void changePower(Power hero_pwr) {
        /* Change the power here */
        this.hero_pwr = hero_pwr;
        }

        public void displayStat() {
        /* Display the Stat here */

        hero_cs.display() ;
        hero_pwr.display() ;

        }

        public void takeDamage(String severity) {
        if(alive == 1 ) {
                try {
                hero_pwr.takeDamage(severity) ;
                } catch (Exception e ) {
                alive = 0 ;
                }
        }
}


class Jak  extends Hero {

}


class Daxter extends Hero {


}



class Costume {
        private String color = "red" ;
        private String highlights= "blue" ;

        public void display() {
        System.out.println("I'm wearing "+
                                 color + " and "+
                                 highlights + "highlights " );


        }
        public Costume change(String new_color , String new_highlights ) {
        /* Change the costumes here */
        /* Throws TooMuchPinkException if you assign pink here */
        this.color = new_color ;
        this.highlights = new_highlights ;
        return this ;
        }


}


class Power {

        private int health ;
        private int med_packs ;
        Power() {
                this.health = 100 ;
                this.med_packs = 5 ;
        }


        Power(int init_health, int init_med_packs) {
         if ( init_health > 100 || init_med_packs > 10 ) {
                /* Throw some exception */

         }
        }

        public void display() {
        System.out.println("Life " + health +
                           "Med "  + med_packs ) ;
        }  /*
        private int isAlive(){
                int alive = 1 ;  // Assume alive
                if(health == 0 && med_packs == 0 )
                        alive = 0 ; // Declare dead

                return alive ;  // Return state
        }
        */

        public void takeDamage(String severity) {

                int damage ;
                int effectiveDamage;

                 switch(severity)  {
                        case "hell" : damage = 5;        break;
                        case "serious" : damage = 3 ;    break;
                        case "minor"  :  damage = 2 ;    break;
                        default:  damage = 1 ;

                }

                health -= damage ;

                if ( health < 1 )
                    health += medpack ;  // use medpack

                if ( health < 1 )  // if still negative
                    throw new Exception("dead" ) ;

        }

}

