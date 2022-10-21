// Select the button from HTML
const button = document.querySelector("button");

// Default states
let theme = true;
button.innerText = "Dark Theme";

// Colors
let black = "rgb(0,0,0)";
let whitesmoke = "rgb(245,245,245)";
let white = "rgb(255,255,255)";

button.addEventListener("click", () => {
  if (theme === true) {
    // Page color
    document.body.style.backgroundColor = black;

    // Text color
    document.body.style.color = whitesmoke;

    // Button text
    button.innerText = "Light Theme";
    theme = false;
  } else {
    // Page color
    document.body.style.backgroundColor = white;

    // Text color
    document.body.style.color = black;

    // Button text
    button.innerText = "Dark Theme";
    theme = true;
  }
});
