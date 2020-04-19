package com.wits.ksw.settings.id6.oneLayout;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.id6.adapter.ID6LanguageAdapter;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ID6LanguageLayout extends RelativeLayout {
    /* access modifiers changed from: private */
    public ID6LanguageAdapter adapter;
    private Context context;
    /* access modifiers changed from: private */
    public List<FunctionBean> data;
    private int defLanguage = 0;
    private LinearLayoutManager layoutManager;
    private List<Locale> locales;
    private RecyclerView recyclerView;

    @RequiresApi(api = 24)
    public ID6LanguageLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.layout_id6_language, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    @RequiresApi(api = 24)
    private void initData() {
        try {
            this.defLanguage = PowerManagerApp.getSettingsInt(KeyConfig.LANGUAGE_DEFUAL);
            this.data = new ArrayList();
            List<String> languags = PowerManagerApp.getDataListFromJsonKey(KeyConfig.LANGUAGE_LIST);
            for (String lang : languags) {
                Log.d("SettingSetLaung", "=====:" + lang);
                FunctionBean fb = new FunctionBean();
                fb.setTitle(lang);
                this.data.add(fb);
            }
            this.data.get(this.defLanguage).setIscheck(true);
            Locale sysLanguage = Locale.getDefault();
            Log.d("SystemLa", "11 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
            int checkInex = -1;
            boolean ishave = false;
            for (int i = 0; i < languags.size(); i++) {
                Log.d("SystemLa", "language:" + this.locales.get(i).getLanguage() + "country:" + this.locales.get(i).getCountry());
                Log.d("SystemLa", "12 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
                if (TextUtils.equals(this.locales.get(i).getLanguage(), sysLanguage.getLanguage()) && this.locales.get(i).getCountry().equals(sysLanguage.getCountry())) {
                    ishave = true;
                    checkInex = i;
                }
            }
            if (ishave) {
                for (FunctionBean lsg : this.data) {
                    lsg.setIscheck(false);
                }
                this.data.get(checkInex).setIscheck(true);
                return;
            }
            for (FunctionBean lsg2 : this.data) {
                lsg2.setIscheck(false);
            }
            FunctionBean fb2 = new FunctionBean();
            fb2.setTitle("Other Languae");
            fb2.setIscheck(true);
            this.data.add(fb2);
        } catch (Exception e) {
        }
    }

    private void initView(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.language_recycle);
        this.layoutManager = new LinearLayoutManager(this.context);
        this.layoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.adapter = new ID6LanguageAdapter(this.context, this.data, 0);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setItemViewCacheSize(30);
        this.adapter.registOnFunctionClickListener(new ID6LanguageAdapter.OnFunctionClickListener() {
            @RequiresApi(api = 24)
            public void functonClick(int pos) {
                for (FunctionBean fb : ID6LanguageLayout.this.data) {
                    fb.setIscheck(false);
                }
                ((FunctionBean) ID6LanguageLayout.this.data.get(pos)).setIscheck(true);
                ID6LanguageLayout.this.adapter.notifyDataSetChanged();
                try {
                    PowerManagerApp.setSettingsInt(KeyConfig.LANGUAGE_DEFUAL, pos);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        });
    }

    private void LocaleList() {
        this.locales = new ArrayList();
        this.locales.add(new Locale("zh", "CN"));
        this.locales.add(new Locale("zh", "TW"));
        this.locales.add(new Locale("en"));
        this.locales.add(new Locale("de"));
        this.locales.add(new Locale("es"));
        this.locales.add(new Locale("ko", "KR"));
        this.locales.add(new Locale("it"));
        this.locales.add(new Locale("nl"));
        this.locales.add(new Locale("ru"));
        this.locales.add(new Locale("fr"));
    }
}
