import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import model.AccrualSubscriber;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {

    private final static String FILE_SUBSCRIBERS = "D:\\Users\\Господа Скакуновы\\Documents\\Миша\\Учеба\\задание1utf Алгоритмы\\Начисление абоненты.csv";
    private final static String FILE_WRITE_HOMES = "D:\\Users\\Господа Скакуновы\\Documents\\Миша\\Учеба\\задание1utf Алгоритмы\\Начисление дома.csv";
    private final static String FILE_READ = "D:\\Users\\Господа Скакуновы\\Documents\\Миша\\Учеба\\задание1utf Алгоритмы\\абоненты.csv";

    public Service() {

    }

    public static List<HomeAccrual> parseHomeAccrual() {
        List<HomeAccrual> homeAccruals = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build(); // custom separator
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(FILE_SUBSCRIBERS))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> r = reader.readAll();
            for (String[] s : r) {
                HomeAccrual homeAccrual = new HomeAccrual();
                homeAccrual.setId(Integer.parseInt(s[0]));
                homeAccrual.setLastName(s[1]);
                homeAccrual.setStreetName(s[2]);
                homeAccrual.setHouseNumber(Integer.parseInt(s[3]));
                homeAccrual.setApartmentNumber(Integer.parseInt(s[4]));
                homeAccrual.setAccrual(Double.parseDouble(s[8]));
                homeAccruals.add(homeAccrual);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return homeAccruals;
    }

    public static List<HomeAccrual> accrualHome(List<HomeAccrual> homeAccruals) {
        double sum;

        for (int i = 0; i < homeAccruals.size(); i++) {
            for (int j = i + 1; j < homeAccruals.size(); j++) {
                if ((homeAccruals.get(i)).getHouseNumber() == (homeAccruals.get(j)).getHouseNumber() &&
                        (homeAccruals.get(i)).getStreetName().equals((homeAccruals.get(j)).getStreetName())) {
                    sum = (homeAccruals.get(i)).getAccrual() + (homeAccruals.get(j)).getAccrual();
                    (homeAccruals.get(j)).setAccrual(0);
                    (homeAccruals.get(i)).setAccrual(sum);
                }
            }
        }
        return homeAccruals;
    }

    public static List<HomeAccrual> accrualsHomesDeleteZero(List<HomeAccrual> homeAccruals) {

        Iterator<HomeAccrual> iterator = homeAccruals.iterator();

        while (iterator.hasNext()) {
            HomeAccrual nextAccrual = iterator.next();
            if (nextAccrual.getAccrual() == 0) {
                iterator.remove();
            }
        }
        return homeAccruals;
    }

    public static List<String[]> toStringArrayHome(List<HomeAccrual> homeAccruals) {
        List<String[]> records = new ArrayList<>();

        records.add(new String[] {"№ Строки", "Улица", "№ дома", "Начислено"});

        for (HomeAccrual homeAccrual : homeAccruals) {
            records.add(new String[]{String.valueOf(homeAccrual.getId()), homeAccrual.getStreetName(),
                    String.valueOf(homeAccrual.getHouseNumber()), String.valueOf(homeAccrual.getAccrual())});
        }
        return records;
    }

    public static void writeAccrualHomes(List<String[]> data) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(FILE_WRITE_HOMES));
        csvWriter.writeAll(data);
        csvWriter.close();
    }

    public static void writeAccrualSubscribers(List<String[]> data) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(FILE_SUBSCRIBERS));
        csvWriter.writeAll(data);
        csvWriter.close();
    }

    public static List<String[]> toStringArray(List<AccrualSubscriber> accrualSubscribers) {
        List<String[]> records = new ArrayList<>();

        records.add(new String[] {"№ Строки", "Фамилия", "Улица", "№ дома", "№ Квартиры", "Тип начисления", "Предыдущее", "Текущее", "Начислено"});

        for (AccrualSubscriber subscriber : accrualSubscribers) {
            records.add(new String[]{String.valueOf(subscriber.getId()), subscriber.getLastName(), subscriber.getStreetName(), String.valueOf(subscriber.getHouseNumber()),
                    String.valueOf(subscriber.getApartmentNumber()), String.valueOf(subscriber.getAccrualType()), String.valueOf(subscriber.getPreviousValue()),
                    String.valueOf(subscriber.getPresentValue()), String.valueOf(subscriber.getAccrual())});
        }
        return records;
    }

    public static List<AccrualSubscriber> accrualSubscribers(List<AccrualSubscriber> accrualSubscribers) {
        double result = 0;
        for (AccrualSubscriber subscriber : accrualSubscribers) {
            int prev = subscriber.getPreviousValue();
            int pres = subscriber.getPresentValue();
            if (subscriber.getAccrualType() == 1) {
                result = 301.26;
            }
            if (subscriber.getAccrualType() == 2) {
                result = (pres - prev) * 1.52;
            }
            subscriber.setAccrual(result);
        }
        System.out.println(accrualSubscribers);
        return accrualSubscribers;
    }

    public static List<AccrualSubscriber> parseAccrualSubscribers() {
        List<AccrualSubscriber> accrualSubscribers = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(FILE_READ))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> r = reader.readAll();
            for (String[] s : r) {
                AccrualSubscriber accrualSubscriber = new AccrualSubscriber();
                accrualSubscriber.setId(Integer.parseInt(s[0]));
                accrualSubscriber.setLastName(s[1]);
                accrualSubscriber.setStreetName(s[2]);
                accrualSubscriber.setHouseNumber(Integer.parseInt(s[3]));
                accrualSubscriber.setApartmentNumber(Integer.parseInt(s[4]));
                accrualSubscriber.setAccrualType(Integer.parseInt(s[5]));
                accrualSubscriber.setPreviousValue(Integer.parseInt(s[6]));
                accrualSubscriber.setPresentValue(Integer.parseInt(s[7]));
                accrualSubscribers.add(accrualSubscriber);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return accrualSubscribers;
    }
}
