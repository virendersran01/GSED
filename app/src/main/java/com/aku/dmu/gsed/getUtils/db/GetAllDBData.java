package com.aku.dmu.gsed.getUtils.db;

import android.content.Context;
import android.os.AsyncTask;

import com.aku.dmu.gsed.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by ali.azaz on 19-Jul-18.
 * UPDATED by ali.azaz on 21-Jun-19.
 */

public class GetAllDBData extends AsyncTask<Object, Void, Collection<?>> {

    String DAOclsName, DAOAbsClsFnc, DAOFnc;
    private AppDatabase db;
    private Context mContext;

    public GetAllDBData(Context mContext, String DAOclsName, String DAOAbsClsFnc, String DAOFnc) {
        this.mContext = mContext;
        this.DAOclsName = DAOclsName;
        this.DAOAbsClsFnc = DAOAbsClsFnc;
        this.DAOFnc = DAOFnc;
    }

    @Override
    protected Collection<?> doInBackground(Object... fnNames) {
        db = AppDatabase.getDatabase(mContext);

        Collection<?> curData = new ArrayList<>();

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(DAOAbsClsFnc)) {

                    Class<?> fnClass = Class.forName(DAOclsName);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(DAOFnc)) {

                            Class<?> params[] = new Class[fnNames.length];
                            for (int i = 0; i < fnNames.length; i++) {
                                if (fnNames[i] instanceof Integer) {
                                    params[i] = Integer.TYPE;
                                } else if (fnNames[i] instanceof String) {
                                    params[i] = String.class;
                                }
                            }

                            curData = (Collection<?>) fnClass.getDeclaredMethod(method2.getName(), params)
                                    .invoke(db.getClass().getMethod(DAOAbsClsFnc).invoke(db), fnNames);


                            break;
                        }
                    }

                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return curData;
    }
}
