// Carrusel de imágenes
let index = 0;
function moveCarousel(direction) {
    const carousel = document.getElementById('carousel');
    const images = document.querySelectorAll('.carousel img');
    const totalImages = images.length;
    const imageWidth = images[0].clientWidth + 20; // Calcula el ancho dinámicamente
    
    index += direction;
    
    if (index < 0) {
        index = totalImages - 1;
    }
    if (index >= totalImages) {
        index = 0;
    }

    carousel.style.transform = `translateX(-${index * imageWidth}px)`;
}

