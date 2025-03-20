document.addEventListener("DOMContentLoaded", function () {
    const tablaAdicionales = document.getElementById("tabla_adicionales_asociados");
    const btnAgregar = document.getElementById("btnAgregar");
    const btnEliminar = document.getElementById("btnEliminar");

    let contador = 0;

    btnAgregar.addEventListener("click", function (e) {
        e.preventDefault();

        const nuevaFila = document.createElement("tr");
        nuevaFila.innerHTML = `
            <td>Adicional:</td>
            <td><input type="number" name="adicionales[${contador}].id" class="input-campo" placeholder="ID adicional"></td>
        `;
        tablaAdicionales.appendChild(nuevaFila);
        contador++;
    });

    btnEliminar.addEventListener("click", function (e) {
        e.preventDefault();
        const filas = tablaAdicionales.getElementsByTagName("tr");
        if (filas.length > 0) {
            tablaAdicionales.removeChild(filas[filas.length - 1]);
            contador--;
        }
    });
});
