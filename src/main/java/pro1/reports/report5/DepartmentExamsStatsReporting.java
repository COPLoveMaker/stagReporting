package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ExamsList;
import pro1.reports.report5.reportDataModel.DepartmentExamsStats;
import java.util.ArrayList;
import java.util.TreeSet;

public class DepartmentExamsStatsReporting {

    public static Object GetReport(DataSource dataSource, String katedra) {

        String json = dataSource.getTerminyZkousek2(katedra);
        ExamsList examsList = new Gson().fromJson(json, ExamsList.class);

        int realizedCount = 0;

        TreeSet<String> rooms = new TreeSet<>();

        if (examsList != null && examsList.items != null) {
            for (var exam : examsList.items) {

                if (exam.studentsCount > 0) {
                    realizedCount++;
                }

                if (exam.room != null && !exam.room.isBlank()) {
                    rooms.add(exam.room);
                }
            }
        }


        return new DepartmentExamsStats(realizedCount, new ArrayList<>(rooms));
    }
}