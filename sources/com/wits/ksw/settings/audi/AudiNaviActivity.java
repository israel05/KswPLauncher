package com.wits.ksw.settings.audi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiNaviBinding;
import com.wits.ksw.settings.audi.vm.NaviVm;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.Iterator;
import java.util.List;

public class AudiNaviActivity extends AudiSubActivity {
    /* access modifiers changed from: private */
    public static final String TAG = ("KSWLauncher." + AudiNaviActivity.class.getSimpleName());
    /* access modifiers changed from: private */
    public NaviAdpater adpater;
    private AudiNaviBinding binding;
    /* access modifiers changed from: private */
    public NaviVm naviVm;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (AudiNaviBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_navi, (ViewGroup) null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        this.naviVm = (NaviVm) ViewModelProviders.of((FragmentActivity) this).get(NaviVm.class);
        this.adpater = new NaviAdpater(this, (List<MapBean>) null);
        this.binding.naviListView.setAdapter(this.adpater);
        this.binding.naviListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                MapBean mapBean = (MapBean) parent.getItemAtPosition(position);
                FileUtils.savaStringData(KeyConfig.NAVI_DEFUAL, mapBean.getPackageName());
                String access$000 = AudiNaviActivity.TAG;
                Log.i(access$000, "NaviApp: " + mapBean.getPackageName());
                List<MapBean> mapBeans = AudiNaviActivity.this.naviVm.naviList.getValue();
                if (mapBeans != null && !mapBeans.isEmpty()) {
                    Iterator<MapBean> it = mapBeans.iterator();
                    while (it.hasNext()) {
                        MapBean mMapBean = it.next();
                        mMapBean.setCheck(mapBean == mMapBean);
                    }
                    AudiNaviActivity.this.adpater.setMapBeans(mapBeans);
                    AudiNaviActivity.this.adpater.notifyDataSetChanged();
                }
            }
        });
        this.naviVm.naviList.observe(this, new Observer<List<MapBean>>() {
            public void onChanged(@Nullable final List<MapBean> mapBeans) {
                String access$000 = AudiNaviActivity.TAG;
                Log.i(access$000, "run: " + mapBeans.size());
                new Handler().post(new Runnable() {
                    public void run() {
                        AudiNaviActivity.this.adpater.setMapBeans(mapBeans);
                        AudiNaviActivity.this.adpater.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    class NaviAdpater extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<MapBean> mapBeans;

        public NaviAdpater(Context context, List<MapBean> mapBeans2) {
            this.mapBeans = mapBeans2;
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setMapBeans(List<MapBean> mapBeans2) {
            this.mapBeans = mapBeans2;
        }

        public int getCount() {
            if (this.mapBeans == null || this.mapBeans.isEmpty()) {
                return 0;
            }
            return this.mapBeans.size();
        }

        public Object getItem(int position) {
            if (this.mapBeans == null || this.mapBeans.isEmpty()) {
                return null;
            }
            return this.mapBeans.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.wits.ksw.settings.audi.AudiNaviActivity$NaviAdpater$ViewHolder} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
            /*
                r5 = this;
                r0 = 0
                if (r7 != 0) goto L_0x002d
                android.view.LayoutInflater r1 = r5.layoutInflater
                r2 = 2131361854(0x7f0a003e, float:1.8343472E38)
                r3 = 0
                android.view.View r7 = r1.inflate(r2, r3)
                com.wits.ksw.settings.audi.AudiNaviActivity$NaviAdpater$ViewHolder r1 = new com.wits.ksw.settings.audi.AudiNaviActivity$NaviAdpater$ViewHolder
                r1.<init>()
                r0 = r1
                r1 = 2131231189(0x7f0801d5, float:1.8078452E38)
                android.view.View r1 = r7.findViewById(r1)
                android.widget.RadioButton r1 = (android.widget.RadioButton) r1
                r0.radioButton = r1
                r1 = 2131231188(0x7f0801d4, float:1.807845E38)
                android.view.View r1 = r7.findViewById(r1)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r0.icon = r1
                r7.setTag(r0)
                goto L_0x0034
            L_0x002d:
                java.lang.Object r1 = r7.getTag()
                r0 = r1
                com.wits.ksw.settings.audi.AudiNaviActivity$NaviAdpater$ViewHolder r0 = (com.wits.ksw.settings.audi.AudiNaviActivity.NaviAdpater.ViewHolder) r0
            L_0x0034:
                java.util.List<com.wits.ksw.settings.id7.bean.MapBean> r1 = r5.mapBeans
                java.lang.Object r1 = r1.get(r6)
                com.wits.ksw.settings.id7.bean.MapBean r1 = (com.wits.ksw.settings.id7.bean.MapBean) r1
                android.widget.ImageView r2 = r0.icon
                android.graphics.drawable.Drawable r3 = r1.getMapicon()
                r2.setImageDrawable(r3)
                android.widget.RadioButton r2 = r0.radioButton
                java.lang.String r3 = r1.getName()
                r2.setText(r3)
                android.widget.RadioButton r2 = r0.radioButton
                boolean r3 = r1.isCheck()
                r2.setChecked(r3)
                java.lang.String r2 = com.wits.ksw.settings.audi.AudiNaviActivity.TAG
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "getView: "
                r3.append(r4)
                java.lang.String r4 = r1.getName()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.util.Log.i(r2, r3)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.settings.audi.AudiNaviActivity.NaviAdpater.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        class ViewHolder {
            ImageView icon;
            RadioButton radioButton;

            ViewHolder() {
            }
        }
    }
}
