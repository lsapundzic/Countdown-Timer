const button = document.querySelector("button");

// Default states
let colorState = true;
button.innerText = "Dark Theme";

// Colors
let black = "rgb(0,0,0)";
let whitesmoke = "rgb(245,245,245)";
let white = "rgb(255,255,255)";

button.addEventListener("click", () => {
  if (colorState === true) {
    // Page color
    document.body.style.backgroundColor = black;
    document.body.style.color = whitesmoke;

    // Button text
    button.innerText = "Light Theme";
    colorState = false;
  } else {
    // Page color
    document.body.style.backgroundColor = white;
    document.body.style.color = black;

    // Button text
    button.innerText = "Dark Theme";
    colorState = true;
  }
});
