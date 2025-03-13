package com.example.portico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portico.entidad.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer> {

       //@Autowired
       //AdicionalRepository adicionalRepository; 
/*
    private Map<Integer, Comida> data = new HashMap<>();

    public ComidaRepository() {

        Adicional quesoExtra = new Adicional(1, "Cheese", 200);
        Adicional baconExtra = new Adicional(2, "Bacon", 300);
        Adicional aguacateExtra = new Adicional(3, "Avocado", 250);
        Adicional huevoExtra = new Adicional(4, "Egg", 150);
        Adicional champiñonesExtra = new Adicional(5, "Mushrooms", 180);
        Adicional jalapenosExtra = new Adicional(6, "Jalapeños", 120);
        Adicional cebollaExtra = new Adicional(7, "Onions", 100);
        Adicional tomateExtra = new Adicional(8, "Tomatoes", 130);
        Adicional lechugaExtra = new Adicional(9, "Lettuce", 90);
        Adicional pepinillosExtra = new Adicional(10, "Pickles", 110);
        Adicional polloExtra = new Adicional(11, "Grilled Chicken", 400);
        Adicional carneExtra = new Adicional(12, "Beef Patty", 500);
        Adicional salamiExtra = new Adicional(13, "Salami", 350);
        Adicional pavoExtra = new Adicional(14, "Turkey", 370);
        Adicional piñaExtra = new Adicional(15, "Pineapple", 160);
        Adicional jamonExtra = new Adicional(16, "Ham", 280);
        Adicional aceitunasExtra = new Adicional(17, "Olives", 140);
        Adicional salsaAjoExtra = new Adicional(18, "Garlic Sauce", 90);
        Adicional salsaBBQExtra = new Adicional(19, "BBQ Sauce", 120);
        Adicional aderezoRanchExtra = new Adicional(20, "Ranch Dressing", 100);

        String defaultImage = "https://www.elespectador.com/resizer/v2/ZQUGSWWM2BBZXHEPBPMRIWX46U.jpg?auth=fba19f13a18b1a314f32e083e9d0727fbbe153571721015b63a21613680c519e&width=920&height=613&smart=true&quality=60";
/*
        Comida comida1 = new Comida(1, "Cheeseburger", 800, "Classic cheeseburger with beef patty and melted cheese.", defaultImage);
        comida1.addAdicional(quesoExtra);
        comida1.addAdicional(cebollaExtra);
        data.put(1, comida1);

        Comida comida2 = new Comida(2, "BBQ Burger", 950, "Smoky BBQ burger with crispy bacon and cheddar cheese.", defaultImage);
        comida2.addAdicional(baconExtra);
        comida2.addAdicional(salsaBBQExtra);
        data.put(2, comida2);

        Comida comida3 = new Comida(3, "Chicken Wrap", 750, "Grilled chicken wrap with lettuce, tomato, and ranch.", defaultImage);
        comida3.addAdicional(polloExtra);
        comida3.addAdicional(aderezoRanchExtra);
        data.put(3, comida3);

        Comida comida4 = new Comida(4, "Pepperoni Pizza", 1200, "Classic pizza topped with pepperoni and mozzarella.", defaultImage);
        comida4.addAdicional(salamiExtra);
        comida4.addAdicional(quesoExtra);
        data.put(4, comida4);

        Comida comida5 = new Comida(5, "Hawaiian Pizza", 1300, "Delicious combination of ham and pineapple.", defaultImage);
        comida5.addAdicional(piñaExtra);
        comida5.addAdicional(jamonExtra);
        data.put(5, comida5);

        Comida comida6 = new Comida(6, "Grilled Steak", 2200, "Juicy steak grilled to perfection.", defaultImage);
        comida6.addAdicional(salsaAjoExtra);
        comida6.addAdicional(champiñonesExtra);
        data.put(6, comida6);

        Comida comida7 = new Comida(7, "Spaghetti Bolognese", 1300, "Traditional Italian pasta with meat sauce.", defaultImage);
        comida7.addAdicional(carneExtra);
        comida7.addAdicional(quesoExtra);
        data.put(7, comida7);

        Comida comida8 = new Comida(8, "Caesar Salad", 850, "Fresh romaine lettuce with Caesar dressing and croutons.", defaultImage);
        comida8.addAdicional(lechugaExtra);
        comida8.addAdicional(tomateExtra);
        data.put(8, comida8);

        Comida comida9 = new Comida(9, "Beef Burrito", 950, "Stuffed burrito with beef, beans, rice, and cheese.", defaultImage);
        comida9.addAdicional(carneExtra);
        comida9.addAdicional(jalapenosExtra);
        data.put(9, comida9);

        Comida comida10 = new Comida(10, "Club Sandwich", 850, "Triple-layer sandwich with turkey, bacon, and tomato.", defaultImage);
        comida10.addAdicional(pavoExtra);
        comida10.addAdicional(baconExtra);
        data.put(10, comida10);

        Comida comida11 = new Comida(11, "French Fries", 450, "Crispy golden fries served with ketchup.", defaultImage);
        comida11.addAdicional(salsaBBQExtra);
        comida11.addAdicional(aderezoRanchExtra);
        data.put(11, comida11);

        Comida comida12 = new Comida(12, "Chocolate Cake", 650, "Rich and moist chocolate cake.", defaultImage);
        comida12.addAdicional(piñaExtra);
        comida12.addAdicional(quesoExtra);
        data.put(12, comida12);

        Comida comida13 = new Comida(13, "Milkshake", 500, "Thick and creamy milkshake in various flavors.", defaultImage);
        comida13.addAdicional(salsaAjoExtra);
        comida13.addAdicional(pepinillosExtra);
        data.put(13, comida13);

        Comida comida14 = new Comida(14, "Iced Coffee", 450, "Chilled coffee with milk and sweetener.", defaultImage);
        comida14.addAdicional(jamonExtra);
        comida14.addAdicional(quesoExtra);
        data.put(14, comida14);

        Comida comida15 = new Comida(15, "Green Tea", 400, "Refreshing and healthy green tea.", defaultImage);
        comida15.addAdicional(lechugaExtra);
        comida15.addAdicional(tomateExtra);
        data.put(15, comida15); 

        
    }

    public Collection<Comida> findAll() {

        return data.values();
    }

    public Comida findById(int id) {

        return data.get(id);
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void update(Comida comida) {
        data.put(comida.getId(), comida);
    }

    public void add(Comida comida) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        comida.setId(lastId + 1);
        data.put(comida.getId(), comida);
    }

    */
}