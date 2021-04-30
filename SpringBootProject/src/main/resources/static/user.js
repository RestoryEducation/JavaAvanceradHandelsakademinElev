class User {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    greetings(){
        return "Mitt namn är "+this.name+" och jag är "+this.age+" år gammal.";
    }
}