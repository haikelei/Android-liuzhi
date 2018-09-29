package components.luyuan.com.androidcomponents.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.List;

import components.luyuan.com.androidcomponents.bean.MutiItem;


public class RecommendAdapter extends BaseMultiItemQuickAdapter<MutiItem, BaseViewHolder> {

    public RecommendAdapter(Context context, List data) {
        super(data);
        addItemType(MutiItem.IMAGE_TEXT_BOTTOM, R.layout.layout_adapter_item_image_text);
        addItemType(MutiItem.IMAGE_TEXT_INSIDE, R.layout.layout_adapter_item_image_text);
        addItemType(MutiItem.IMAGE_TEXT_TOP, R.layout.layout_adapter_item_image_text);
        addItemType(MutiItem.SECTION_HEADER, R.layout.layout_adapter_section_header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MutiItem item) {
        switch (helper.getItemViewType()) {
            case MutiItem.IMAGE_TEXT_BOTTOM:
//                helper.setText(R.id.tv, item.getContent());
                helper.setGone(R.id.ll_top,false);
                helper.setGone(R.id.rl_center,false);
                break;
            case MutiItem.IMAGE_TEXT_INSIDE:
                helper.setGone(R.id.ll_top,false);
                helper.setGone(R.id.ll_bottom,false);
                break;
            case MutiItem.IMAGE_TEXT_TOP:
                helper.setGone(R.id.rl_center,false);
                helper.setGone(R.id.ll_bottom,false);
                break;
            case MutiItem.SECTION_HEADER:

                break;
        }
    }

}
