public class Test {

    public static void main(String[] args) {

       /* Grid grid = new Grid();
        grid.generate(GridTypes.MENU);// initial --> initial screen
        grid.getRepresentation().draw();
        Game game = new Game();
        game.init();
        game.generateMouse();
        game.getObjects()[15].summon();
        //intro
        //gamescreen
        //credits              <-- use this four keywords when creating the screens like the example above ;)


        Player cenas = new Player();
    }*/

       Game g=new Game();
       g.init();
       try{
           g.start();
       } catch (InterruptedException e) {
           System.out.println("Error");
       }




    }
}

