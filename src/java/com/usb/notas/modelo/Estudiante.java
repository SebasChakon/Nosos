package com.usb.notas.modelo;

/**
 * Clase Estudiante (Programacion Orientada a Objetos).
 *
 * Encapsula la informacion academica del estudiante (nombre y cuatro notas)
 * y contiene la logica de negocio pedida en la guia:
 *   - calcularPromedio()
 *   - determinarAprobacion()
 *   - determinarRendimientoCualitativo()
 *
 * Es un POJO simple: no depende de ningun framework, por eso lo pueden
 * usar tanto el DAO (para guardar/leer de MySQL) como el Servlet.
 */
public class Estudiante {

    private int id;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double promedio;
    private String estado;                 // "Aprobado" o "No aprobado"
    private String resultadoCualitativo;    // Rendimiento insuficiente / Aprobado / ...

    public Estudiante() {
    }

    public Estudiante(String nombre, double nota1, double nota2, double nota3, double nota4) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    // ---------- Logica de negocio (POO) ----------

    /**
     * Calcula el promedio de las cuatro notas y lo deja redondeado a un decimal.
     */
    public void calcularPromedio() {
        double suma = nota1 + nota2 + nota3 + nota4;
        double resultado = suma / 4.0;
        this.promedio = Math.round(resultado * 10.0) / 10.0;
    }

    /**
     * Determina si el estudiante aprueba (promedio >= 3.0).
     */
    public void determinarAprobacion() {
        this.estado = (this.promedio >= 3.0) ? "Aprobado" : "No aprobado";
    }

    /**
     * Determina la valoracion cualitativa segun la escala de la guia:
     *   0.0 - 2.9 -> Rendimiento insuficiente
     *   3.0 - 3.9 -> Aprobado
     *   4.0 - 4.5 -> Aprobado con sobresaliente
     *   4.6 - 5.0 -> Aprobado con excelente
     */
    public void determinarRendimientoCualitativo() {
        if (this.promedio < 3.0) {
            this.resultadoCualitativo = "Rendimiento insuficiente";
        } else if (this.promedio < 4.0) {
            this.resultadoCualitativo = "Aprobado";
        } else if (this.promedio <= 4.5) {
            this.resultadoCualitativo = "Aprobado con sobresaliente";
        } else {
            this.resultadoCualitativo = "Aprobado con excelente";
        }
    }

    /**
     * Ejecuta en orden las tres operaciones anteriores.
     */
    public void evaluar() {
        calcularPromedio();
        determinarAprobacion();
        determinarRendimientoCualitativo();
    }

    // ---------- Validacion basica ----------

    /**
     * Valida que el nombre no este vacio y que las notas esten en rango 0.0 - 5.0.
     * Devuelve un mensaje de error, o null si todo esta correcto.
     */
    public String validar() {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre del estudiante es obligatorio.";
        }
        if (fueraDeRango(nota1) || fueraDeRango(nota2) || fueraDeRango(nota3) || fueraDeRango(nota4)) {
            return "Todas las notas deben estar entre 0.0 y 5.0.";
        }
        return null;
    }

    private boolean fueraDeRango(double nota) {
        return nota < 0.0 || nota > 5.0;
    }

    // ---------- Getters y setters ----------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultadoCualitativo() {
        return resultadoCualitativo;
    }

    public void setResultadoCualitativo(String resultadoCualitativo) {
        this.resultadoCualitativo = resultadoCualitativo;
    }
}
