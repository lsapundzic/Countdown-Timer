const button = document.querySelector("button");
let colorState = true;

button.addEventListener("click", () => {
  if (colorState === true) {
    // Page color
    document.body.style.backgroundColor = "rgb(0,0,0)";
    document.body.style.color = "rgb(245,245,245)";

    // Button text
    button.innerText = "Light Theme";
    colorState = false;
  } else {
    // Page color
    document.body.style.backgroundColor = "rgb(255,255,255)";
    document.body.style.color = "rgb(0,0,0)";

    // Button text
    button.innerText = "Dark Theme";
    colorState = true;
  }
});
