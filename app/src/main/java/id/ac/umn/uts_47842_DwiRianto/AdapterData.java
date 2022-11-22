package id.ac.umn.uts_47842_DwiRianto;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String> listData;
    LayoutInflater layoutInflater;
    String name;
    LinearLayout Yes,No;

    public AdapterData(Context context, List<String> listData, String name) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
        this.name = name;
    }

    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.data_file, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {
        holder.textdata.setText(listData.get(position));
        int numberPosisi = position + 1;
        String nameVideo = "Video " + numberPosisi;
        Log.i("TAG" , "Posisi: " + nameVideo);
        holder.textdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Video " , Toast.LENGTH_SHORT).show();
            }
        });
        holder.listData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailFile.class);
                intent.putExtra("name", name);
                intent.putExtra("nameVideo", nameVideo);
                v.getContext().startActivity(intent);
            }
        });
        holder.DelData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(v.getContext());
                bottomSheetDialog.setContentView(R.layout.bottom_dialog);
                bottomSheetDialog.setCanceledOnTouchOutside(false);
                bottomSheetDialog.show();

                Yes = bottomSheetDialog.findViewById(R.id.Yes);
                No = bottomSheetDialog.findViewById(R.id.No);

                No.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                Yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listData.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, listData.size());
                        bottomSheetDialog.dismiss();
                    }
                });

            }
        });
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView textdata;
        ImageView DelData;
        LinearLayout listData;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            textdata = itemView.findViewById(R.id.namaList);
            DelData = itemView.findViewById(R.id.DelData);
            listData = itemView.findViewById(R.id.listData);
        }
    }
}
