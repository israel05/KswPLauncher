package com.wits.ksw.databinding;

import android.content.res.Resources;
import android.databinding.DataBindingComponent;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class Id7SubPhoneViewBindingSw600dpLandImpl extends Id7SubPhoneViewBinding implements OnClickListener.Listener {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    @Nullable
    private final View.OnClickListener mCallback16;
    private long mDirtyFlags;

    static {
        sViewsWithIds.put(R.id.textView2, 5);
    }

    public Id7SubPhoneViewBindingSw600dpLandImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private Id7SubPhoneViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, bindings[4], bindings[3], bindings[2], bindings[0], bindings[1], bindings[5]);
        this.mDirtyFlags = -1;
        this.dayTextView.setTag((Object) null);
        this.monthTextView.setTag((Object) null);
        this.phoneConnectionTextView.setTag((Object) null);
        this.phoneConstraintLayout.setTag((Object) null);
        this.phoneImageView.setTag((Object) null);
        setRootTag(root);
        this.mCallback16 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (4 != variableId) {
            return false;
        }
        setNaviViewModel((LauncherViewModel) variable);
        return true;
    }

    public void setNaviViewModel(@Nullable LauncherViewModel NaviViewModel) {
        this.mNaviViewModel = NaviViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeNaviViewModelDay((ObservableField) object, fieldId);
            case 1:
                return onChangeNaviViewModelMonth((ObservableField) object, fieldId);
            case 2:
                return onChangeNaviViewModelPhoneConState((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeNaviViewModelDay(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNaviViewModelMonth(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNaviViewModelPhoneConState(ObservableInt NaviViewModelPhoneConState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long dirtyFlags;
        Resources resources;
        int i;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> naviViewModelDay = null;
        ObservableField<String> naviViewModelMonth = null;
        int naviViewModelPhoneConStateGet = 0;
        String naviViewModelDayGet = null;
        String naviViewModelMonthGet = null;
        LauncherViewModel naviViewModel = this.mNaviViewModel;
        String naviViewModelPhoneConStateInt0PhoneConnectionTextViewAndroidStringKswId7NotConnectedPhonePhoneConnectionTextViewAndroidStringKswId7ConnectedPhone = null;
        ObservableInt naviViewModelPhoneConState = null;
        View.OnFocusChangeListener naviViewModelPhoneViewFocusChangeListener = null;
        if ((31 & dirtyFlags) != 0) {
            if ((dirtyFlags & 25) != 0) {
                if (naviViewModel != null) {
                    naviViewModelDay = naviViewModel.day;
                }
                updateRegistration(0, (Observable) naviViewModelDay);
                if (naviViewModelDay != null) {
                    naviViewModelDayGet = naviViewModelDay.get();
                }
            }
            boolean z = true;
            if ((dirtyFlags & 26) != 0) {
                if (naviViewModel != null) {
                    naviViewModelMonth = naviViewModel.month;
                }
                updateRegistration(1, (Observable) naviViewModelMonth);
                if (naviViewModelMonth != null) {
                    naviViewModelMonthGet = naviViewModelMonth.get();
                }
            }
            if ((dirtyFlags & 28) != 0) {
                if (naviViewModel != null) {
                    naviViewModelPhoneConState = naviViewModel.phoneConState;
                }
                updateRegistration(2, (Observable) naviViewModelPhoneConState);
                if (naviViewModelPhoneConState != null) {
                    naviViewModelPhoneConStateGet = naviViewModelPhoneConState.get();
                }
                if (naviViewModelPhoneConStateGet != 0) {
                    z = false;
                }
                boolean naviViewModelPhoneConStateInt0 = z;
                if ((dirtyFlags & 28) != 0) {
                    if (naviViewModelPhoneConStateInt0) {
                        dirtyFlags |= 64;
                    } else {
                        dirtyFlags |= 32;
                    }
                }
                if (naviViewModelPhoneConStateInt0) {
                    resources = this.phoneConnectionTextView.getResources();
                    i = R.string.ksw_id7_not_connected_phone;
                } else {
                    resources = this.phoneConnectionTextView.getResources();
                    i = R.string.ksw_id7_connected_phone;
                }
                String string = resources.getString(i);
                boolean z2 = naviViewModelPhoneConStateInt0;
                naviViewModelPhoneConStateInt0PhoneConnectionTextViewAndroidStringKswId7NotConnectedPhonePhoneConnectionTextViewAndroidStringKswId7ConnectedPhone = string;
            }
            if (!((dirtyFlags & 24) == 0 || naviViewModel == null)) {
                naviViewModelPhoneViewFocusChangeListener = naviViewModel.phoneViewFocusChangeListener;
            }
        }
        if ((dirtyFlags & 25) != 0) {
            TextViewBindingAdapter.setText(this.dayTextView, naviViewModelDayGet);
        }
        if ((dirtyFlags & 26) != 0) {
            TextViewBindingAdapter.setText(this.monthTextView, naviViewModelMonthGet);
        }
        if ((dirtyFlags & 28) != 0) {
            TextViewBindingAdapter.setText(this.phoneConnectionTextView, naviViewModelPhoneConStateInt0PhoneConnectionTextViewAndroidStringKswId7NotConnectedPhonePhoneConnectionTextViewAndroidStringKswId7ConnectedPhone);
        }
        if ((16 & dirtyFlags) != 0) {
            this.phoneImageView.setOnClickListener(this.mCallback16);
        }
        if ((dirtyFlags & 24) != 0) {
            this.phoneImageView.setOnFocusChangeListener(naviViewModelPhoneViewFocusChangeListener);
        }
    }

    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel naviViewModel = this.mNaviViewModel;
        if (naviViewModel != null) {
            naviViewModel.openBtApp(callbackArg_0);
        }
    }
}
