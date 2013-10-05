package com.example.listviewdinamico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import calculatedays.ColorEnum;
import calculatedays.Day;
import calculatedays.SimpleDate;

public class MainActivity extends Activity {

	private ListView lista;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);
       Calendar cal = GregorianCalendar.getInstance();
       cal.set(Calendar.DAY_OF_MONTH, 28);
       cal.set(Calendar.YEAR, 2013);
       cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        

        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
        Day dia = new Day(cal,true,"hola",ColorEnum.BLUE);
       
        dia.calculateFertilesDays();
        for(int i=0; i<=cal.MONTH; i++){
        for(SimpleDate fecha : dia.getSimpleDatesList()) {
        	
        	datos.add(new Lista_entrada(R.drawable.unnamed, fecha.toString(), fecha.getColor().toString()));
        	 cal.add(Calendar.MONTH,1);
        }
        }
       
 
        
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.activity_main, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});

        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });

    }
}
