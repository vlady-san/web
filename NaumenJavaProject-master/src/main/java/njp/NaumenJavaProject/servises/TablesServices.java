package njp.NaumenJavaProject.servises;

import njp.NaumenJavaProject.dao.TablesDao;
import njp.NaumenJavaProject.models.Tables;

import java.util.List;

public class TablesServices {
    private TablesDao tablesDao = new TablesDao();

    public TablesServices() {
    }

    public Tables findUser(int id) {
        return tablesDao.findById(id);
    }

    public List<Integer> findAllBooked(String date ){

        return tablesDao.findAllBooked(date);
    }

    public void saveUser(Tables tables) {
        tablesDao.save(tables);
    }

    public void deleteUser(Tables tables) {
        tablesDao.delete(tables);
    }

    public void updateUser(Tables tables) {
        tablesDao.update(tables);
    }
}
