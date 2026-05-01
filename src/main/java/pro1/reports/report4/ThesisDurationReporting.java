package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.ThesisStats;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ThesisDurationReporting {

    public static Object[] GetReport(DataSource dataSource, String katedra, String[] years) {
        var results = new ArrayList<ThesisStats>();
        var gson = new Gson();

        for (String year : years) {
            String json = dataSource.getKvalifikacniPrace(year, katedra);
            ThesisList list = gson.fromJson(json, ThesisList.class);

            long totalDays = 0;
            int count = 0;

            if (list != null && list.items != null) {
                for (var thesis : list.items) {

                    if (thesis.dateAssigned != null && thesis.dateAssigned.isValid() &&
                            thesis.dateSubmitted != null && thesis.dateSubmitted.isValid()) {

                        var start = thesis.dateAssigned.toLocalDate();
                        var end = thesis.dateSubmitted.toLocalDate();

                        if (start != null && end != null) {
                            totalDays += ChronoUnit.DAYS.between(start, end);
                            count++;
                        }
                    }
                }
            }


            int avg = (count > 0) ? (int) Math.round((double) totalDays / count) : 0;
            results.add(new ThesisStats(year, avg));
        }

        return results.toArray();
    }
}