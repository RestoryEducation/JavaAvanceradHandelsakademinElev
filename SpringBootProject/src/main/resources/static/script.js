document.write("<p>Hello World</p>");

function generateMessage() {
    document.getElementById("output").innerHTML = "This is a generated message!";
}

function generateUsers() {
    var user1 = new User("Marcus", 32);
    var user2 = new User("Sandra", 37);

    user1.favoriteColor = "Green";

    document.getElementById("output").innerHTML = user2.greetings();
}
