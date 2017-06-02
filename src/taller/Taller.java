/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author santi
 */
public class Taller {

    private class Producto{
        private String nombre;
        private float precio;
        private String contenido;

        public Producto() {
            
        }

        public Producto(String nombre, float precio, String contenido) {
            this.nombre = nombre;
            this.precio = precio;
            this.contenido = contenido;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }

      
        public void setContenido(String contenido) {
            this.contenido = contenido;
        }

        public String getNombre() {
            return nombre;
        }

        public float getPrecio() {
            return precio;
        }

      

        public String getContenido() {
            return contenido;
        }
        
        
    } //fin clase producto
    
    private Producto[] sortArrayAsc(Producto[] arrayProd){
        Producto productAux;//declaro un objeto de transicion
        int countProd=arrayProd.length;//para mejor claridad almaceno el tamaño del array dentro de una variable
        for(int i=0;i<countProd-1;i++){//recorro el array hasta la anteultima posicion
            for (int j=i+1;j<countProd;j++){//recorro el array desde la segunda posicion hasta la ultima
                //comparo la posicion actual con las que siguen, si es mayor, se troca
                if(arrayProd[i].getPrecio()>arrayProd[j].getPrecio()){ 
                    productAux= arrayProd[i];
                    arrayProd[i]=arrayProd[j];
                    arrayProd[j]=productAux;
                }
            }
        }// fin del for
        return arrayProd;
    }
    //metodo que se dedica a cargar el array , retorna un array de objetos Producto
    private Producto[] setContent(){

        Producto producto1= new Producto("Coca-Cola Zero",20,"Litros:1.5");
        Producto producto2= new Producto("Coca-Cola",18,"Litros:1.5");
        Producto producto3= new Producto("Shampoo Sedal",30,"Contenido:500mm");
        Producto producto4= new Producto("Frutillas",64,"Unidad de venta: kilo");
        
        Producto[] arrayProd=new Producto[4];
        arrayProd[0]=producto1;
        arrayProd[1]=producto2;
        arrayProd[2]=producto3;
        arrayProd[3]=producto4;
        return arrayProd;
     
    }
    //metodo solo dedicado a imprimir la salida
    private void print(){
        //llamo al metodo para cargar el array
        Producto[] producto= setContent();
        for (Producto producto1 : producto) {
            //este parche es porque el orden de salida esta desestructurado
            //todas las frutillas saldran en un orden diferente
            if (producto1.getNombre() != "Frutillas") {
                System.out.println("Nombre: " + producto1.getNombre() + "///" 
                        + producto1.getContenido() + 
                        "///" + "Precio: " + "$" + producto1.getPrecio());
            } else {
                System.out.println("Nombre: " + producto1.getNombre() + "///" 
                        + "Precio: " + "$" + producto1.getPrecio() + 
                        "///" +  producto1.getContenido());
            }
        }//fin for
        System.out.println("================================================================");
        //ordeno el array (tambien podria analizarse el mayor y el menor recorriendo el
        //vector y guardando en una variable el numero mas grande o mas chico hasta llegar al final)
        producto=sortArrayAsc(producto);
        //el producto mas caro sera el ultimo del array ordenado ascendentemente
        //supongo que no se el tamaño del array...
        System.out.println("Producto mas caro: "+ producto[producto.length-1].getNombre());
        //el mas barato sera el primero, todo array comienza con indice 0
         System.out.println("Producto mas caro: "+ producto[0].getNombre());
        
    }
    
    public static void main(String[] args) {
        Taller taller=new Taller();
        taller.print();
        
    }
    
}
