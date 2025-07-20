package com.example.trainingtasks.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingtasks.R;
import com.example.trainingtasks.models.valueset_get;

import java.util.ArrayList;

public class RecycyleV_Adapter extends RecyclerView.Adapter<RecycyleV_Adapter.viewholder>{
    ArrayList<valueset_get> list;
    Context con;
    String swami="Put your heart,mind,and soul into evenour smallest acts .this is the secret of success";
    String im8 ="money is the root of all evil";
    String im6="over thinking kills your happiness";
    String img= "the way i see it , if you want the rainbow ,you gotta put up with the rain.";
    String lalbaha="force will be met by force. whether we remain or nott let this country rwemain strong ,and let this flag keep flying .";
    String modiji="we live in an inter-dependent world. an isolated india is not our interest ";
    String som= "from the unreal lead us to the real, from darkness lead us to light , from death unto immortality.";
    String ssardar="MY ONLY DESIRE IS THAT INDIA SHOULD BE A GOOD PRODUCER AND NO ONE SHOULD BE HUNGRY, SHEDDING TEARS FOR FOOD IN THE COUNTRY.";
    String sabdul="Dreams is not what you see in sleep is the thing which doesn't let you sleep ";
    String sbhagat="If the deaf are to hear, the sound has to be very loud ";
    String sbill="Be nice to nerds. Chances are you'll end up working for one." ;
    String sdown=  "I'm glad this business has no expenses and I get to pocket all this money... said no photographer ever. I'm glad this business has no expenses and I get to pocket all this money... sa";
    String sdown2="Your time is limited, so don't waste it living someone else's life.";
    String smusk="I could either watch it happen or be a part of it.I could either watch it happen or be a part of it.";
    String sgan ="If you want to become fearless choose love";
    String sim3=" Life is like riding a bicycle. To keep your balance, you must keep moving.";
    String sim4="Manpower without unity is not a strength.";
    String sim2=" When it rains look for rainbows...";
    String img7="People cry,not because they're weak .it's because they've been strong for too long";





    String share;
    public RecycyleV_Adapter(ArrayList<valueset_get> list, Context con) {
        this.list = list;
        this.con = con;

    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(con).inflate(R.layout.setup_cardview,parent,false);

        return new viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
    valueset_get v = list.get(position);
    holder.i.setImageResource(v.getPicture());
//    holder.t.setText(v.getTxt());


    switch (position){
        case 0:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
        holder.t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,ssardar);
                con.startActivity(intent);
            }
        });
        break;







        case 1:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
        holder.t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,sabdul);
                con.startActivity(intent);
            }
        });
        break;
        case 2:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sbhagat);
                    con.startActivity(intent);
                }
            });
            break;



        case 3:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sbill);
                    con.startActivity(intent);
                }
            });
            break;



        case 4:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sdown2);
                    con.startActivity(intent);
                }
            });
            break;



        case 5:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,smusk);
                    con.startActivity(intent);
                }
            });
            break;




        case 6:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sgan);
                    con.startActivity(intent);
                }
            });
            break;




        case 7:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sim3);
                    con.startActivity(intent);
                }
            });
            break;

        case 8:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,sim2);
                    con.startActivity(intent);
                }
            });
            break;

        case 9:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,img7);
                    con.startActivity(intent);
                }
            });
            break;

        case 10:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,im6);
                    con.startActivity(intent);
                }
            });
            break;

        case 11:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,swami);
                    con.startActivity(intent);
                }
            });
            break;

        case 12:holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(con, "", Toast.LENGTH_SHORT).show();


            }
        });
            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,img);
                    con.startActivity(intent);
                }
            });
            break;
    }




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView i;

        ImageView  t;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            i= itemView.findViewById(R.id.img);
            t=itemView.findViewById(R.id.share);

        }


    }
}
