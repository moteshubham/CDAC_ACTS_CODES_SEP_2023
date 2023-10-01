class SpaceShuttle {
      constructor(targetPlanet) {
        this.targetPlanet = targetPlanet;
      }
      takeOff() {
        console.log("To " + this.targetPlanet + "!");
      }
    }
    
    // Implicit constructor 
    class Rocket {
      launch() {
        console.log("To the moon!");
      }
    }
    
    const zeus = new SpaceShuttle('Jupiter');
    // prints To Jupiter! in console
    zeus.takeOff();
    
    const atlas = new Rocket();
    // prints To the moon! in console
    atlas.launch();
    