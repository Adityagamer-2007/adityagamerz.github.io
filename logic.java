// FINAL FIXED SLIDER (No bugs, fully working)

document.addEventListener("DOMContentLoaded", function () {
  const slides = document.querySelectorAll(".slider .slide");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");

  let index = 0;
  const total = slides.length;

  // Show slide based on index
  function update() {
    slides.forEach(slide => slide.classList.remove("active"));
    slides[index].classList.add("active");

    // Disable prev button only when index = 0
    if (index === 0) {
      prevBtn.classList.add("disabled");
      prevBtn.setAttribute("aria-disabled", "true");
    } else {
      prevBtn.classList.remove("disabled");
      prevBtn.removeAttribute("aria-disabled");
    }
  }

  update(); // initialize slider

  // NEXT -> always move to next (wrap to first)
  nextBtn.addEventListener("click", () => {
    index = (index + 1) % total;
    update();
  });

  // PREVIOUS -> move backward (stop at first)
  prevBtn.addEventListener("click", () => {
    if (index > 0) {
      index--;
      update();
    }
  });

  // Keyboard Support
  document.addEventListener("keydown", (e) => {
    if (e.key === "ArrowRight") nextBtn.click();
    if (e.key === "ArrowLeft") prevBtn.click();
  });
});
