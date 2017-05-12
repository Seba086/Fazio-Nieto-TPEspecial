package TPE;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	// C:\TUDAI-ws\Fazio-Nieto-TPEspecial\datasets
	final static String path500k = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/dataset_500000.csv";
	final static String path1m = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/dataset_1000000.csv";
	final static String path3m = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/dataset_3000000.csv";
	final static String pathAlta = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/dataset_insert_10000.csv";
	final static String pathBusqueda = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/dataset_busqueda_10000.csv";
	final static String resultBusqueda500k_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda500k_array.csv";
	final static String resultAlta500k_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta500k_array.csv";
	final static String resultBusqueda1m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda1m_array.csv";
	final static String resultBusqueda3m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda3m_array.csv";
	final static String resultAlta1m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta1m_array.csv";
	final static String resultAlta3m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta3m_array.csv";
	final static String resultBusqueda500k_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda500k_listainicio.csv";
	final static String resultAlta500k_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta500k_listainicio.csv";
	final static String resultBusqueda1m_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda1m_listainicio.csv";
	final static String resultBusqueda3m_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda3m_listainicio.csv";
	final static String resultAlta1m_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta1m_listainicio.csv";
	final static String resultAlta3m_listaInicio = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta3m_listainicio.csv";
	final static String resultBusqueda500k_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda500k_listaFinal.csv";
	final static String resultAlta500k_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta500k_listaFinal.csv";
	final static String resultBusqueda1m_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda1m_listaFinal.csv";
	final static String resultBusqueda3m_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidabusqueda3m_listaFinal.csv";
	final static String resultAlta1m_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta1m_listaFinal.csv";
	final static String resultAlta3m_listaFinal = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial/datasets/salidaalta3m_listaFinal.csv";

	public static void main(String[] args) throws IOException {
		// 500k
		UserLinkedList listaPrincipio500k = new UserLinkedList(true, path500k, resultBusqueda500k_listaInicio,resultAlta500k_listaInicio);
		UserLinkedList listaFinal500k = new UserLinkedList(true, path500k, resultBusqueda500k_listaFinal,resultAlta500k_listaFinal);
		UserArray listaArray500k = new UserArray(path500k, resultBusqueda500k_array, resultAlta500k_array);
		// 1m
		
		UserLinkedList listaPrincipio1m = new UserLinkedList(true, path1m,resultBusqueda1m_listaInicio,resultAlta1m_listaInicio);
		UserLinkedList listaFinal1m = new UserLinkedList(true, path500k,resultBusqueda1m_listaFinal ,resultAlta1m_listaFinal); 
		UserArray listaArray1m = new UserArray(path1m, resultBusqueda1m_array ,resultAlta1m_array); 
		//3m 
		UserLinkedList listaPrincipio3m = new UserLinkedList(true, path3m,resultBusqueda3m_listaInicio,resultAlta3m_listaInicio);
		UserLinkedList listaFinal3m = new UserLinkedList(true, path500k,resultBusqueda3m_listaFinal ,resultAlta3m_listaFinal); 
		UserArray listaArray3m = new UserArray(path3m, resultBusqueda3m_array ,resultAlta3m_array);
		 

		// Busqueda y alta usuarios 500k

		listaPrincipio500k.buscarUsuarios(pathBusqueda);
		listaPrincipio500k.altaUsuarios(pathAlta);
		listaFinal500k.buscarUsuarios(pathBusqueda);
		listaFinal500k.altaUsuarios(pathAlta);
		listaArray500k.buscarUsuarios(pathBusqueda);
		listaArray500k.altaUsuarios(pathAlta);

		// Busqueda y alta usuarios 1m

		listaPrincipio1m.buscarUsuarios(pathBusqueda);
		listaPrincipio1m.altaUsuarios(pathAlta);
		listaFinal1m.buscarUsuarios(pathBusqueda);
		listaFinal1m.altaUsuarios(pathAlta);
		listaArray1m.buscarUsuarios(pathBusqueda);
		listaArray1m.altaUsuarios(pathAlta);
		
		// Busqueda y alta usuarios 3m

		listaPrincipio3m.buscarUsuarios(pathBusqueda);
		listaPrincipio3m.altaUsuarios(pathAlta);
		listaFinal3m.buscarUsuarios(pathBusqueda);
		listaFinal3m.altaUsuarios(pathAlta);
		listaArray3m.buscarUsuarios(pathBusqueda);
		listaArray3m.altaUsuarios(pathAlta);

	}
}
