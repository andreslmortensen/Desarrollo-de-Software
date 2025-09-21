import TRAZA1.*;

import TRAZA2.*;
import Traza1y2.SucursalArticulo;
import repositorios.InMemoryRepository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Inicializar repositorios
        InMemoryRepository<SucursalArticulo> sucursalArticuloRepository = new InMemoryRepository<>();
        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();
        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();
        System.out.println(" -----------PROBAMOS EL SISTEMA ----------");
        Pais argentina = Pais.builder().nombre("Argentina").
                build();

        // Crear provincias y localidades
        Provincia buenosAires = Provincia.builder()
                .id(1L)
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();

        Localidad caba = Localidad.builder()
                .id(1L)
                .nombre("CABA")
                .provincia(buenosAires)
                .build();

        Domicilio domicilio1 = Domicilio.builder()
                .id(1L)
                .calle("Calle 1")
                .numero(100)
                .cp(1000)
                .localidad(caba)
                .build();

        Localidad laPlata = Localidad.builder()
                .id(2L)
                .nombre("La Plata")
                .provincia(buenosAires)
                .build();

        Domicilio domicilio2 = Domicilio.builder()
                .id(2L)
                .calle("Calle 2")
                .numero(200)
                .cp(2000)
                .localidad(laPlata)
                .build();


        Provincia cordoba = Provincia.builder()
                .id(2L)
                .nombre("Córdoba")
                .pais(argentina)
                .build();

        Localidad cordobaCapital = Localidad.builder()
                .id(3L)
                .nombre("Córdoba Capital")
                .provincia(cordoba)
                .build();

        Domicilio domicilio3 = Domicilio.builder()
                .id(3L)
                .calle("Calle 3")
                .numero(300)
                .cp(3000)
                .localidad(cordobaCapital)
                .build();


        Localidad villaCarlosPaz = Localidad.builder()
                .id(4L)
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();


        Domicilio domicilio4 = Domicilio.builder()
                .id(4L)
                .calle("Calle 4")
                .numero(400)
                .cp(4000)
                .localidad(villaCarlosPaz)
                .build();

        // Crear sucursales Para buenos Aires
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .es_Casa_Matriz(true)
                .domicilio(domicilio1)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .es_Casa_Matriz(false)
                .domicilio(domicilio2)
                .build();

        // Crear Sucursales Para Cordoba

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .es_Casa_Matriz(true)
                .domicilio(domicilio3)
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .es_Casa_Matriz(false)
                .domicilio(domicilio4)
                .build();

        // Crear empresas y asociar sucursales
        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("Razon Social 1")
                .cuit(1231567)
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .razonSocial("Razon Social 2")
                .cuit(2222564)
                .sucursales(new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();

        // Guardar empresas en el repositorio
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);
        // Crear categorías
        Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
        Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
        Categoria lomos = Categoria.builder().denominacion("Lomos").esInsumo(false).build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();

        categoriaRepository.save(pizzas);
        categoriaRepository.save(sandwiches);
        categoriaRepository.save(lomos);
        categoriaRepository.save(insumos);

        // Crear unidades de medida
        UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos = UnidadMedida.builder().denominacion("Gramos").build();

        unidadMedidaRepository.save(kg);
        unidadMedidaRepository.save(litro);
        unidadMedidaRepository.save(gramos);

        // Crear artículos insumos
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .precioCompra(1.0)
                .stockActual(100)
                .stockMaximo(200)
                .esParaElaborar(true)
                .unidadMedida(gramos)
                .build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .precioCompra(0.5)
                .stockActual(50)
                .stockMaximo(100)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .precioCompra(3.0)
                .stockActual(30)
                .stockMaximo(60)
                .esParaElaborar(true)
                .unidadMedida(litro)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .precioCompra(5.0)
                .stockActual(20)
                .stockMaximo(40)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .build();

        articuloInsumoRepository.save(sal);
        articuloInsumoRepository.save(harina);
        articuloInsumoRepository.save(aceite);
        articuloInsumoRepository.save(carne);

        // Crear imágenes para los artículos
        ImagenArticulo img1 = ImagenArticulo.builder().
                name("HawaianaPizza1").url("http://example.com/pizza1").build();
        ImagenArticulo img2 = ImagenArticulo.builder().name("HawaianaPizza2").url("http://example.com/pizza2").build();
        ImagenArticulo img3 = ImagenArticulo.builder().name("HawaianaPizza3").url("http://example.com/pizza3").build();
        ImagenArticulo img4 = ImagenArticulo.builder().name("LomoCompletoLomo1").url("http://example.com/lomo1").build();
        ImagenArticulo img5 = ImagenArticulo.builder().name("LomoCompletoLomo2").url("http://example.com/lomo2").build();
        ImagenArticulo img6 = ImagenArticulo.builder().name("LomoCompletoLomo3").url("http://example.com/lomo3").build();

        // Crear detalles de artículos manufacturados
        ArticuloManufacturadoDetalle detalle1PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(harina)
                .build();

        ArticuloManufacturadoDetalle detalle3PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle1LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle3LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(carne)
                .build();

        // Crear artículos manufacturados
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .precioVenta(12.0)
                .descripcion("Pizza con piña y jamón")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 20 minutos")
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(15.0)
                .descripcion("Lomo completo con todos los ingredientes")
                .tiempoEstimadoMinutos(25)
                .preparacion("Cocinar a la parrilla por 25 minutos")
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1LomoCompleto, detalle2LomoCompleto, detalle3LomoCompleto)))
                .build();

        articuloManufacturadoRepository.save(pizzaHawaina);
        articuloManufacturadoRepository.save(lomoCompleto);

        SucursalArticulo aprobacion1 = SucursalArticulo.builder().
                sucursal(sucursal1).
                articulo(sal).
                precio(500).
                stock(20).
                aprobacion(true).
                fechaAlta(LocalDate.now()).
                build();

        SucursalArticulo aprobacion2 = SucursalArticulo.builder().
                id(123456789012345L).
                sucursal(sucursal2).
                articulo(harina).
                precio(800).
                stock(0).
                aprobacion(false).
                fechaAlta(LocalDate.now()).
                build();
        // Guardar aprobaciones en el repositorio
        sucursalArticuloRepository.save(aprobacion1);
        sucursalArticuloRepository.save(aprobacion2);

        // Mostrar todas las aprobaciones
        System.out.println("Todas las aprobaciones:");
        List<SucursalArticulo> todasLasAprobaciones = sucursalArticuloRepository.findAll();
        todasLasAprobaciones.forEach(System.out::println);


    }
}




