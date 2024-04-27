import java.util.ArrayList;
import java.util.List;

public class CoffeMachineMenu {

    private static final List<String> logs = new ArrayList<>();
    public static final int minMilkMl = 0;
    public static final int maxMilkMl = 1000;
    public static final int minWaterMl = 0;
    public static final int maxWaterMl = 3000;
    public static final int waterMlCleanCoffeMachine = 10;
    public static final int maxCoffeBeansGrams = 500;
    public static final int minCoffeBeansGrams = 0;
    public static final int minCoffeMachineDirty = 10;
    public static final int maxCoffeMachineDirty = 100;
    static int realWaterMl = 3000;
    static int realMilkMl = 1000;
    static int realCoffeBeansGrams = 500;
    static int realCoffeMachineDirty = 0;
    static int waterForPortion = 50;
    static int milkForPortion = 20;
    static int coffeBeansForPortion = 20;
    static int coffeMachineDirtyForPortion = 10;
    static List<CoffeMachineProfile> profileList = new ArrayList<>();
    static String nameProfile;
    static int cupsCapuchinoProfile;
    static int cupsEspressoProfile;
    static boolean cupsProfile;
    static int indexProfile;

    public static void main(String[] args) {
        int button;
        do {
            System.out.println("1. Вкл");
            System.out.println("2. Выкл");
            System.out.println("3. Логи приготовленых напитков");
            button = ScanUtility.scanInt();
            switch (button) {
                case 1:
                    do {
                        System.out.println("1. Статус Кофемашины ");
                        System.out.println("2. Кофе и профили");
                        System.out.println("3. Вернуться назад");
                        button = ScanUtility.scanInt();
                        switch (button) {
                            case 1:
                                do {
                                    System.out.println("Вода: " + realWaterMl + " мл.");
                                    System.out.println("Кофе: " + realCoffeBeansGrams + " г.");
                                    System.out.println("Молоко: " + realMilkMl + " мл.");
                                    System.out.println("Кофемашина загрязнена: " + realCoffeMachineDirty + " %\n");
                                    System.out.println("1. Пополнить воду");
                                    System.out.println("2. Пополнить кофейные зерна");
                                    System.out.println("3. Пополнить молоко");
                                    System.out.println("4. Очистка Кофемашины");
                                    System.out.println("5. Вернуться назад");
                                    button = ScanUtility.scanInt();
                                    switch (button) {
                                        case 1:
                                            System.out.println("Воды в кофемашине: " + realWaterMl + " мл");
                                            System.out.println("Максимальный объем воды: " + maxWaterMl + " мл");
                                            addWater();
                                            break;
                                        case 2:
                                            System.out.println("Кофейных зерен в кофемашине: " + realCoffeBeansGrams + " грамм");
                                            System.out.println("Максимальный объем кофейных зерен " + maxCoffeBeansGrams + " грамм");
                                            addCoffeBeans();
                                            break;
                                        case 3:
                                            System.out.println("Молока в кофемашине: " + realMilkMl + " мл");
                                            System.out.println("Максимальный объем молока: " + maxMilkMl + " мл");
                                            addMilk();
                                            break;
                                        case 4:
                                            if (realCoffeMachineDirty < minCoffeMachineDirty) {
                                                System.out.println("Кофемашине не требуется читска");
                                            } else if (realWaterMl < waterMlCleanCoffeMachine) {
                                                System.out.println("В кофемашине недостаточно воды для очистки");
                                            } else {
                                                realCoffeMachineDirty = 0;
                                                realWaterMl -= waterMlCleanCoffeMachine;
                                                System.out.println("Кофемашина очищена");
                                                logs.add("кофемашина очищена");
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Возвращаемся назад");
                                            break;
                                        default:
                                            System.out.println("Некорректный ввод");
                                            break;
                                    }
                                } while (button != 5);
                                break;
                            case 2:
                                int button2;
                                do {
                                    System.out.println("1. Сделать кофе");
                                    System.out.println("2. Профили");
                                    System.out.println("3. Вернуться назад");
                                    button2 = ScanUtility.scanInt();
                                    switch (button2) {
                                        case 1:
                                            do {
                                                System.out.println("1. Капучино");
                                                System.out.println("2. Эспрессо");
                                                System.out.println("3. Сделать 3 капучино");
                                                System.out.println("4. Сделать 3 эспрессо");
                                                System.out.println("5. Посмотреть рецепты");
                                                System.out.println("6. Вернуться назад");
                                                button2 = ScanUtility.scanInt();
                                                switch (button2) {
                                                    case 1:
                                                        System.out.println("введите колличество порций");
                                                        int value = ScanUtility.scanInt();
                                                        makeCoffeCapuchino(value);
                                                        break;
                                                    case 2:
                                                        System.out.println("введите колличество порций");
                                                        value = ScanUtility.scanInt();
                                                        makeCoffeEspresso(value);
                                                        break;
                                                    case 3:
                                                        makeCoffeCapuchino(3);
                                                        break;
                                                    case 4:
                                                        makeCoffeEspresso(3);
                                                        break;
                                                    case 5:
                                                        System.out.println("Капучино: " + Recept.CAPUCHINO.takeDiscriptions());
                                                        System.out.println("Еспрессо: " + Recept.ESPRESSO.takeDiscriptions());
                                                        break;
                                                    case 6:
                                                        System.out.println("Возвращение назад");
                                                        break;
                                                    default:
                                                        System.out.println("Некорректный ввод");
                                                        break;
                                                }
                                            } while (button2 != 6);
                                            break;
                                        case 2:
                                            int button3;
                                            do {
                                                System.out.println("1. Доступные профили");
                                                System.out.println("2. Создать профиль");
                                                System.out.println("3. Вернуться назад");
                                                button3 = ScanUtility.scanInt();
                                                switch (button3) {
                                                    case 1:
                                                        System.out.println("Доступные профили: ");
                                                        if (profileList.isEmpty()) {
                                                            System.out.println("Список пуст");
                                                        } else {
                                                            int i = 0;
                                                            for (CoffeMachineProfile profile : profileList) {
                                                                i++;
                                                                System.out.println(i + ". " + profile.getName());
                                                            }
                                                            System.out.println("выберите профиль для приготовления кофе");
                                                            System.out.println("или введите 0 чтобы вернуться назад");
                                                            indexProfile = ScanUtility.scanInt() - 1;
                                                            if (indexProfile == -1) {
                                                            } else {
                                                                CoffeMachineProfile specificObject = profileList.get(indexProfile);
                                                                makeCoffeCapuchino(specificObject.getCapsCapuchino());
                                                                makeCoffeEspresso(specificObject.getCapsEspresso());
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        addProfile();
                                                        System.out.println("Создание профиля");
                                                        break;
                                                    case 3:
                                                        System.out.println("Возвращение назад");
                                                        break;
                                                    default:
                                                        System.out.println("Некорректный ввод");
                                                        break;
                                                }
                                            } while (button3 != 3);
                                            break;
                                        case 3:
                                            System.out.println("Возвращение назад");
                                            break;
                                        default:
                                            System.out.println("Некорректный ввод");
                                            break;
                                    }
                                } while (button2 != 3);
                                break;
                            case 3:
                                System.out.println("Возвращение назад");
                                break;
                            default:
                                System.out.println("Некорректный ввод");
                                break;
                        }
                    } while (button != 3);
                    break;
                case 2:
                    System.out.println("Выключение кофемашины");
                    break;
                case 3:
                    for (String log : logs) {
                        System.out.println(log);
                    }
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуй еще");
                    break;
            }
        } while (button != 2);
    }

    static void addWater() {
        int realWaterMlAdd;
        if (realWaterMl == maxWaterMl){
            System.out.println("максимаьное колличество воды, пополнить нельзя");
        }
        else {
            do {
                System.out.println("Введите количество воды желаемого для пополнения в миллилитрах");
                realWaterMlAdd = ScanUtility.scanInt();
                if (realWaterMlAdd + realWaterMl > maxWaterMl) {
                    System.out.println("Нельзя добавить такое колличество воды");
                    System.out.println("Вводимое колличество воды превышает максимальное на " + (realWaterMl + realWaterMlAdd - maxWaterMl) + " мл");
                    System.out.println("Введите другое количество добавляемой воды");
                }
            } while (realWaterMlAdd + realWaterMl > maxWaterMl);
            realWaterMl += realWaterMlAdd;
            System.out.println("вода добавлена\nводы в кофемашине: " + realWaterMl);
            logs.add("Вода добавлена " + realWaterMlAdd + " мл");
        }
    }

    static void addMilk() {
        int realMilkAdd;
        if (realMilkMl == maxMilkMl){
            System.out.println("максимаьное колличество молока, пополнить нельзя");
        }
        else {
            do {
                System.out.println("Введите количество молока желаемого для пополнения в миллилитрах");
                realMilkAdd = ScanUtility.scanInt();
                if (realMilkAdd + realMilkMl > maxMilkMl) {
                    System.out.println("Нельзя добавить такое колличество молока");
                    System.out.println("Вводимое колличество молока превышает максимальное на " + (realMilkMl + realMilkAdd - maxMilkMl) + " мл");
                    System.out.println("Введите другое количество добавляемого молока");
                }
            } while (realMilkAdd + realMilkMl > maxMilkMl);
            realMilkMl += realMilkAdd;
            System.out.println("молоко добавлено\nмолока в кофемашине: " + realMilkMl);
            logs.add("Молоко добавлено " + realMilkAdd + " мл");
        }
    }

    static void addCoffeBeans() {
        int realCoffeBeansGramsAdd;
        if(realCoffeBeansGrams == maxCoffeBeansGrams){
            System.out.println("максимальное колличество зерен, пополнить нельзя");
        }
        else{
            do {
                System.out.println("Введите количество кофейных зерен желаемого для пополнения в граммах");
                realCoffeBeansGramsAdd = ScanUtility.scanInt();
                if (realCoffeBeansGramsAdd + realCoffeBeansGrams > maxCoffeBeansGrams) {
                    System.out.println("Нельзя добавить такое колличество кофейных зерен");
                    System.out.println("Вводимое колличество кофейных зерен превышает максимальное на " + (realCoffeBeansGramsAdd + realCoffeBeansGrams - maxCoffeBeansGrams) + " грамм");
                    System.out.println("Введите другое количество добавляемых кофейных зерен");
                }
            } while (realCoffeBeansGramsAdd + realCoffeBeansGrams > maxCoffeBeansGrams);
            realCoffeBeansGrams += realCoffeBeansGramsAdd;
            System.out.println("кофейные зерна добавлены\nкофейных зерен в кофемашине: " + realCoffeBeansGrams);
            logs.add("Кофейные зерна добавлены" + realCoffeBeansGramsAdd + "грамм");
        }
    }

    static void makeCoffeCapuchino(int portions) {
        if (realCoffeBeansGrams - coffeBeansForPortion * portions >= minCoffeBeansGrams) {
            if (realWaterMl - waterForPortion * portions >= minWaterMl) {
                if (realMilkMl - milkForPortion * portions >= minMilkMl) {
                    if (realCoffeMachineDirty + coffeMachineDirtyForPortion * portions <= maxCoffeMachineDirty) {
                        realCoffeMachineDirty += coffeMachineDirtyForPortion * portions;
                        realWaterMl -= waterForPortion * portions;
                        realMilkMl -= milkForPortion * portions;
                        realCoffeBeansGrams -= coffeBeansForPortion * portions;
                        System.out.println("Ваш кофе капучино в количестве " + portions + ("шт., готов"));
                        logs.add("Капучино " + portions + " шт приготовлены");
                    } else {
                        System.out.println("Надо почистить кофемашину");
                        System.out.println("Количество порций доступных для приготовления без очистки " + (maxCoffeMachineDirty - realCoffeMachineDirty) + " шт");
                    }
                } else {
                    System.out.println("Не хватает молока " + (milkForPortion * portions - realMilkMl) + " мл");
                }
            } else {
                System.out.println("Не хватает воды " + (waterForPortion * portions - realWaterMl) + " мл");
            }
        } else {
            System.out.println("Не хватает кофеных зерен " + (coffeBeansForPortion * portions - realCoffeBeansGrams) + " грамм");
        }
    }

    static void makeCoffeEspresso(int portions) {
        if (realCoffeBeansGrams - coffeBeansForPortion * portions >= minCoffeBeansGrams) {
            if (realWaterMl - waterForPortion * portions >= minWaterMl) {
                if (realCoffeMachineDirty + coffeMachineDirtyForPortion * portions <= maxCoffeMachineDirty) {
                    realCoffeMachineDirty += coffeMachineDirtyForPortion * portions;
                    realWaterMl -= waterForPortion * portions;
                    realMilkMl -= milkForPortion * portions;
                    realCoffeBeansGrams -= coffeBeansForPortion * portions;
                    System.out.println("Ваш кофе эспрессо в количестве " + portions + ("шт., готов"));
                    logs.add("Капучино " + portions + " шт приготовлены");
                } else {
                    System.out.println("Надо почистить кофемашину");
                    System.out.println("Количество порций доступных для приготовления без очистки " + (maxCoffeMachineDirty - realCoffeMachineDirty) + " шт");
                }
            } else {
                System.out.println("Не хватает воды " + (waterForPortion * portions - realWaterMl) + " мл");
            }
        } else {
            System.out.println("Не хватает кофеных зерен " + (coffeBeansForPortion * portions - realCoffeBeansGrams) + " грамм");
        }
    }

    public static void addProfile() {
        System.out.println("введите имя профиля");
        nameProfile = ScanUtility.scanLine();
        for (CoffeMachineProfile profile : profileList) {
            if (profile.getName().equals(nameProfile)) {
                System.out.println("Профиль с таким именем есть");
                return;
            }
        }
        cupsProfile = false;
        while (cupsProfile == false) {
            System.out.println("Для создания профиля должна быть добавлена хот бы одна чашка кофе и сумма чашек не должна превышать " + maxCoffeMachineDirty / coffeMachineDirtyForPortion + " шт");
            System.out.println("Введите желаемое колличество кружек капучино в профиле");
            cupsCapuchinoProfile = ScanUtility.scanInt();
            System.out.println("Введите желаемое колличество кружек эспрессо в профиле");
            cupsEspressoProfile = ScanUtility.scanInt();
            if ((cupsEspressoProfile * coffeMachineDirtyForPortion + cupsCapuchinoProfile * coffeMachineDirtyForPortion <= maxCoffeMachineDirty) && (cupsCapuchinoProfile > 0 || cupsEspressoProfile > 0)) {
                profileList.add(new CoffeMachineProfile(nameProfile, cupsEspressoProfile, cupsCapuchinoProfile));
                logs.add("профиль с именем "+ nameProfile + " создан\n");

                cupsProfile = true;
            } else {
                System.out.println("Введенное настройки неудовлетворяют условиям");
            }
        }
    }
}
