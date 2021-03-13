package com.epsilon.training.annotations.processors;

import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.annotations.XmlProperty;
import com.epsilon.training.annotations.XmlSerializable;
import com.epsilon.training.entity.XmlIgnored;
import com.epsilon.training.exceptions.NotXmlSerializableException;

public class XmlSerializer {

	public void serialize(Writer writer, Object obj) {
		String json = this.serialize(obj);
		try (PrintWriter out = new PrintWriter(writer);) {
			out.print(json);
		}
	}

	public String serialize(Object obj) {

		if (obj == null) {
			throw new NotXmlSerializableException("Cannot serialize a null object!");
		}

		// cls represents the class, obj is an object of
		Class<?> cls = obj.getClass();

		if (!cls.isAnnotationPresent(XmlSerializable.class)) {
			throw new NotXmlSerializableException("The class " + cls.getName() + " does not have @XmlSerializable");
		}

		List<String> kvList = new ArrayList<>();

		for (Field f : cls.getDeclaredFields()) {

			if (!f.isAnnotationPresent(XmlIgnored.class)) {
				try {

					String label = f.getName();
					XmlProperty ann = f.getAnnotation(XmlProperty.class);

					if (ann != null) {
						label = ann.label();
						if (label == null || label.trim().equals("")) {
							label = f.getName();
						}
					}

					f.setAccessible(true);
					Class<?> c = f.get(obj).getClass(); // f.get(obj) returns the value we need the class of this value
														// so getClass()
					if (c.isAnnotationPresent(XmlSerializable.class)) {
						XmlSerializer js = new XmlSerializer();

						String json = js.serialize(f.get(obj));
						kvList.add(json);
					} else {
						String kv = String.format("\t<%s>%s</%s>", label, f.get(obj),label);
						kvList.add(kv);
					}
				} catch (Exception e) {
					System.err.println("Erorr for field " + f.getName() + " - " + e.getMessage());
				}
			}
		}

		StringBuffer sb = new StringBuffer(10000);
		String startend=obj.getClass().getSimpleName();
		sb.append("<"+startend+">\n");
		for (int i = 0, j = kvList.size() - 1; i < j; i++) {
			sb.append(kvList.get(i));
			sb.append("\n ");
		}
		sb.append(kvList.get(kvList.size() - 1));

		sb.append("\n</"+startend+">");

		return sb.toString();
	}
}
