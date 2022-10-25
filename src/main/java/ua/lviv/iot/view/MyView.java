/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.view
 * Class: MyView
 **/

package ua.lviv.iot.view;


import ua.lviv.iot.controller.BatteryController;
import ua.lviv.iot.controller.SolarPanelController;
import ua.lviv.iot.controller.IPaddressController;
import ua.lviv.iot.controller.ClientController;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.domain.IPaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private SolarPanelController solarPanelController;

    @Autowired
    private ClientController clientController;

    @Autowired
    private BatteryController batteryController;

    @Autowired
    private IPaddressController IPaddressController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final SolarPanel nullSolarPanel = new SolarPanel(null, null, null, null, null);
    final Battery nullBattery = new Battery(null, null, null, null);
    final Client nullClient = new Client(null, null, null, null, null);
    final IPaddress nullIPaddress = new IPaddress(null);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: SolarPanel");
        menu.put("11", "  11 - Create SolarPanel");
        menu.put("12", "  12 - Update SolarPanel");
        menu.put("13", "  13 - Delete from SolarPanel");
        menu.put("14", "  14 - Find all SolarPanels");
        menu.put("15", "  15 - Find SolarPanel by ID");
        menu.put("16", "  16 - Find SolarPanel by genre");
        menu.put("17", "  17 - Find SolarPanel by rating");

        menu.put("2", "   2 - Table: Client");
        menu.put("21", "  21 - Create Client");
        menu.put("22", "  22 - Update Client");
        menu.put("23", "  23 - Delete from Client");
        menu.put("24", "  24 - Find all Clients");
        menu.put("25", "  25 - Find Client by ID");

        menu.put("3", "   3 - Table: Battery");
        menu.put("31", "  31 - Create Battery");
        menu.put("32", "  32 - Update Battery");
        menu.put("33", "  33 - Delete from Battery");
        menu.put("34", "  34 - Find all Batteries");
        menu.put("35", "  35 - Find Battery by ID");
        menu.put("36", "  36 - Find all SolarPanels by Battery ID");

        menu.put("4", "   4 - Table: IPaddress");
        menu.put("41", "  41 - Create IPaddress");
        menu.put("42", "  42 - Update IPaddress");
        menu.put("43", "  43 - Delete from IPaddress");
        menu.put("44", "  44 - Find all IPaddresses");
        menu.put("45", "  45 - Find IPaddress by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createSolarPanel);
        methodsMenu.put("12", this::updateSolarPanel);
        methodsMenu.put("13", this::deleteFromSolarPanel);
        methodsMenu.put("14", this::findAllSolarPanels);
        methodsMenu.put("15", this::findSolarPanelById);
        methodsMenu.put("16", this::findSolarPanelBySolarPanelGenre);
        methodsMenu.put("17", this::findSolarPanelBySolarPanelRating);

        methodsMenu.put("21", this::createClient);
        methodsMenu.put("22", this::updateClient);
        methodsMenu.put("23", this::deleteFromClient);
        methodsMenu.put("24", this::findAllClients);
        methodsMenu.put("25", this::findClientById);

        methodsMenu.put("31", this::createBattery);
        methodsMenu.put("32", this::updateBattery);
        methodsMenu.put("33", this::deleteFromBattery);
        methodsMenu.put("34", this::findAllBatteries);
        methodsMenu.put("35", this::findBatteryById);
        methodsMenu.put("36", this::findAllSolarPanelsById);

        methodsMenu.put("41", this::createIPaddress);
        methodsMenu.put("42", this::updateIPaddress);
        methodsMenu.put("43", this::deleteFromIPaddress);
        methodsMenu.put("44", this::findAllIPaddresses);
        methodsMenu.put("45", this::findIPaddressById);
    }

    private void selectAllTable() {
        findAllSolarPanels();
        findAllClients();
        findAllBatteries();
        findAllIPaddresses();
    }

    // region SolarPanel ---------------------------------------------------
    private void createSolarPanel() {
        System.out.println("Input 'model': ");
        String model = input.nextLine();
        System.out.println("Input 'type': ");
        String type = input.nextLine();
        System.out.println("Input 'currentAngle': ");
        Integer currentAngle = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'IPaddress': ");
        String IPaddress = input.nextLine();
        SolarPanel solarPanel = new SolarPanel(null, model, type, currentAngle, IPaddress);

        int count = solarPanelController.create(solarPanel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSolarPanel() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'model': ");
        String model = input.nextLine();
        System.out.println("Input new 'type': ");
        String type = input.nextLine();
        System.out.println("Input new 'currentAngle': ");
        Integer currentAngle = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'IPaddress': ");
        String IPaddress = input.nextLine();
        SolarPanel solarPanel = new SolarPanel(null, model, type, currentAngle, IPaddress);

        int count = solarPanelController.update(id, solarPanel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromSolarPanel() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = solarPanelController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSolarPanels() {
        System.out.println("\nTable: SOLAR_PANEL");
        List<SolarPanel> solarPanels = solarPanelController.findAll();
        for (SolarPanel solarPanel : solarPanels) {
            System.out.println(solarPanel);
        }
    }

    private void findSolarPanelById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<SolarPanel> solarPanel = solarPanelController.findById(id);
        System.out.println(solarPanel.orElse(nullSolarPanel));
    }

    private void findSolarPanelBySolarPanelGenre() {
        System.out.println("Input 'solarPanel ipaddress': ");
        String ipaddress = input.nextLine();

        Optional<SolarPanel> solarPanel = solarPanelController.findByIPaddress(ipaddress);
        System.out.println(solarPanel.orElse(nullSolarPanel));
    }

    private void findSolarPanelBySolarPanelRating() {
        System.out.println("Input 'currentAngle': ");
        Integer currentAngle = Integer.valueOf((input.nextLine()));

        Optional<SolarPanel> solarPanel = solarPanelController.findByCurrentAngle(currentAngle);
        System.out.println(solarPanel.orElse(nullSolarPanel));
    }
    //endregion solarPanel


    // region USER ------------------------------------------
    private void createClient() {
        System.out.println("Input 'client surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'client name': ");
        String name = input.nextLine();
        System.out.println("Input 'client password': ");
        String password = input.nextLine();
        System.out.println("Input 'client isACompany': ");
        Boolean isACompany = Boolean.valueOf(input.nextLine());

        Client client = new Client(null, surname, name, password ,isACompany);

        int count = clientController.create(client);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateClient() {
        System.out.println("Input new 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'client surname': ");
        String surname = input.nextLine();
        System.out.println("Input new 'client name': ");
        String name = input.nextLine();
        System.out.println("Input new 'client password': ");
        String password = input.nextLine();
        System.out.println("Input new 'client isACompany': ");
        Boolean isACompany = Boolean.valueOf(input.nextLine());

        Client client = new Client(null, surname, name, password ,isACompany);

        int count = clientController.update(id, client);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromClient() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = clientController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllClients() {
        System.out.println("\nTable: CLIENT");
        List<Client> clients = clientController.findAll();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void findClientById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Client> client = clientController.findById(id);
        System.out.println(client.orElse(nullClient));
    }
    //endregion USER


    // region Battery -------------------------------------------------
    private void createBattery() {
        System.out.println("Input 'model': ");
        String model = input.nextLine();
        System.out.println("Input 'capacity': ");
        Integer capacity = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'IPaddress': ");
        String IPaddress = input.nextLine();

        Battery battery = new Battery(null, model, capacity, IPaddress);

        int count = batteryController.create(battery);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateBattery() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'model': ");
        String model = input.nextLine();
        System.out.println("Input new 'capacity': ");
        Integer capacity = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'IPaddress': ");
        String IPaddress = input.nextLine();

        Battery battery = new Battery(null, model, capacity, IPaddress);

        int count = batteryController.update(id, battery);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromBattery() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = batteryController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllBatteries() {
        System.out.println("\nTable: STEAM");
        List<Battery> batteries = batteryController.findAll();
        for (Battery battery : batteries) {
            System.out.println(battery);
        }
    }

    private void findBatteryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Battery> steam = batteryController.findById(id);
        System.out.println(steam.orElse(nullBattery));
    }

    private void findAllSolarPanelsById() {
        System.out.println("Input 'steam id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<SolarPanel> solarPanels = batteryController.findAllSolarPanelsBy(id);
        for (SolarPanel solarPanel : solarPanels) {
            System.out.println(solarPanel);
        }
    }
    //endregion STEAM


    // region IPaddress
    private void createIPaddress() {
        System.out.println("Input new 'IPaddress': ");
        String ipaddress = input.nextLine();

        IPaddress IPaddress = new IPaddress( ipaddress);

        int count = IPaddressController.create(IPaddress);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateIPaddress() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'IPaddress': ");
        String ipaddress = input.nextLine();

        IPaddress IPaddress = new IPaddress( ipaddress);

        int count = IPaddressController.update(id, IPaddress);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromIPaddress() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = IPaddressController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllIPaddresses() {
        System.out.println("\nTable: IPADDRESS");
        List<IPaddress> IPaddresses = IPaddressController.findAll();
        for (IPaddress IPaddress : IPaddresses) {
            System.out.println(IPaddress);
        }
    }

    private void findIPaddressById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<IPaddress> platform = IPaddressController.findById(id);
        System.out.println(platform.orElse(nullIPaddress));
    }
    // endregion IPADDRESS

    //-------------------------------------------------------------------------

    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }


            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
    //endregion output

}
