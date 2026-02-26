/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

/*
Constructor de la clase Animal.

Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.

Realiza validaciones sobre los parámetros:

El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
El sexo debe ser 'M' (hembra) o 'H' (macho).
El peso debe ser un valor positivo mayor que cero.
La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido.

Si algún parámetro no cumple estas condiciones, se lanza una excepción IllegalArgumentException

@param el código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula

@param fechaNacimiento  la fecha de nacimiento del animal en formato "yyyy-MM-dd"

@param sexo el sexo del animal, 'M' para hembra o 'H' para macho

@param peso el peso del animal en kilogramos, debe ser mayor que 0

@throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto, el peso no es positivo o la fecha no tiene un formato válido

*/
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /*
    Método getCodigo
    Devuelve el código asignado a un objeto
    @return codigo devuelve el valor de código actual de la objeto
    */
    public String getCodigo() {
        return codigo;
    }

     /*
    Método setCodigo
    Modifica el codigo nuevo en una objeto por el codigo del parametro pedido
    Comprueba que el codigo es una cadena de 5 caracteres alfacnumericos y en caso contrario devuelve una excepción 
    this.codigo variable que hace referencia al código actual de la objeto
    @param codigo cadena de caracteres que serán el nuevo código de la objeto
    @throws IllegalArgumentException() en caso de que el nuevo codigo no cumpla con los parámetros devuelve esta excepción
    */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

     /*
    Método getFechaNacimiento
    Devuelve la fecha de nacimiento de la objeto
    @return fechaNacimiento devuelve el valor de fechaNacimiento de la objeto
    */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

     /*
    Método setFechaNacimiento
    Proporciona el parámetro fechaNacimiento de una nueva objeto
    convierte el paramatro fecha en una variable LocalDate
    en caso de que fechaNacimiento no tenga el formato correcto devuelve la excepción IllegalArgumentException
    fecha variable de tipo LocalDate
    @param fechaNacimiento cadena de caracteres que debería estar en formato AAAA-MM-DD
    @throws IllegalArgumentException() en caso de que el formato de la fecha sea incorrecto
    */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

     /*
    Método getSexo
    Devuelve el sexo de la objeto 
    @return sexo nos devuleve el valor de sexo de la objeto
    */
    public char getSexo() {
        return sexo;
    }

     /*
    Método setSexo
    Modifica el sexo de una objeto
    comprueba que si el carácter introducido no coincide con 'M' o 'H'
    en caso de que se cumpla devuelve una excepción
    en caso contrario modifica el sexo actual del animal por el parametro introducido
    this.sexo variable que contiene el valor actual de sexo en la objeto
    @param sexo parametro char que debe coincidir con el valor 'M' o 'F'
    */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

     /*
    Método getPeso
    Devuelve el peso de la objeto
    @reurn peso devuelve el valor del peso de la objeto
    */
    public double getPeso() {
        return peso;
    }

     /*
    Método setPeso
    Modifica el valor de peso de la objeto por el parametro introducido
    comprueba si peso es menor o igual a 0 en ese caso devuelve la excepción IllegalArgumentException()
    en caso contrario modifica el valor de peso de la objeto por el parametro introducido
    this.peso variable que hace referencia al valor actual de peso en la objeto
    @param peso parametro de tipo double que contiene el valor que queremos asignar a peso
    @throws IllegalArgumentException() si el peso resulta ser menor o igual a 0 devuelve esta excepción
    */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

     /*
    Método hashCode
    Método que sobrescribe el método hashCode
    modifica el valor de hash mediante varias operaciones
    para obtener el codigo hash del objeto
    varibale hash de tipo int
    @return hash devuelve el valor hash después de calcularlo
    */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

     /*
    Método equals
    Comprueba si existe o no el objeto introducido si existe devuelve true
    en caso de que el objeto introducido sea null devuelve falso
    en caso de que no sea capaz de encontrar la clase a la que pertenece el objeto devuelve falso
    en final convierte el objeto a Animal y compara suss valores con la objeto actual
    en caso de que alguno de los valores no coincida devuelve falso
    @param obj parámetro que contiene el nombre de la objeto que vamos a comprobar en el método
    @return true si los objetos son iguales, false si no lo son
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

     /*
    Método toString
    devuelve una cadena de texto donde se nos informa del valor de los parametros de una objeto
    @return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}' devuelve una linea de texto donde se nos dice los valores actuales de una objeto
    */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
     /*
    Método abstracto hacerSonido
    no es un metodo implementado en Animal.java
    */
    public abstract String hacerSonido();
     /*
    Método abstracto alegrarse
    no es un metodo implementado en Animal.java
    */
    public abstract String alegrarse();
     /*
    Método abstracto enfadarse
    no es un metodo implementado en Animal.java
    */
    public abstract String enfadarse();
     /*
    Método abstracto queSoy
    no es un metodo implementado en Animal.java
    */
    public abstract String queSoy();

}
