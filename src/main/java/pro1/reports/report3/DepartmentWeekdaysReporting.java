package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.WeekdayCount;
import java.util.ArrayList;

public class DepartmentWeekdaysReporting {
    public static Object[] GetReport(DataSource dataSource, String rok, String katedra, String[] days) {
        String json = dataSource.getRozvrhByKatedra(rok, katedra);
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);
        var result = new ArrayList<WeekdayCount>();

        for (String day : days) {
            int count = (int) actions.items.stream()
                    .filter(a -> day.equalsIgnoreCase(a.dayShortcut))
                    .count();
            result.add(new WeekdayCount(day, count));
        }
        return result.toArray();
    }
}