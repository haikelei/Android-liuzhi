package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.MutiItem;
import com.hykj.liuzhi.androidcomponents.ui.glide.GlideRoundTransform;


public class RecommendAdapter extends BaseMultiItemQuickAdapter<MutiItem, BaseViewHolder> {

    public RecommendAdapter(Context context, List data) {
        super(data);
        addItemType(MutiItem.IMAGE_TEXT_BOTTOM, R.layout.layout_adapter_item_image_text_bottom);
        addItemType(MutiItem.IMAGE_TEXT_INSIDE, R.layout.layout_adapter_item_image_text_inside);
        addItemType(MutiItem.IMAGE_TEXT_TOP, R.layout.layout_adapter_item_image_text_top);
        addItemType(MutiItem.SECTION_HEADER, R.layout.layout_adapter_section_header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MutiItem item) {
        switch (helper.getItemViewType()) {
            case MutiItem.IMAGE_TEXT_BOTTOM:

                loadImage(helper);

                break;
            case MutiItem.IMAGE_TEXT_INSIDE:
                loadImage(helper);
                break;
            case MutiItem.IMAGE_TEXT_TOP:
                loadImage(helper);
                break;
            case MutiItem.SECTION_HEADER:

                break;
        }
    }

    private void loadImage(BaseViewHolder helper) {
        ImageView imageView = helper.getView(R.id.iv_center);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transform(new GlideRoundTransform(helper.itemView.getContext(),6)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);


        Glide.with(helper.itemView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load(R.mipmap.test2)
                .into(imageView);
    }


}
