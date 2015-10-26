package com.swed.puzzle.writer.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.swed.puzzle.domain.House;
import com.swed.puzzle.domain.Solution;
import com.swed.puzzle.writer.OutputWriter;

/**
 * 
 * @author mmackevicius
 *
 */
public class XslOutputWriter implements OutputWriter {

	private static final String SOLUTIONS_TAG_NAME = "solutions";
	private static final String SOLUTION_TAG_NAME = "solution";
	private static final String HOUSE_TAG_NAME = "house";

	@Override
	public void write(List<Solution> solutions) {
		try {
			Transformer transformer = createTransformer();
			Document xmlDocument = createXmlDocument(solutions);
			
			
			transformer.transform(new DOMSource(xmlDocument),
					new StreamResult(new FileOutputStream("outputFile.html")));

		} catch (ParserConfigurationException | TransformerException | FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private Document createXmlDocument(List<Solution> solutions) throws ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement(SOLUTIONS_TAG_NAME);
		doc.appendChild(rootElement);

		for (Solution solution : solutions) {
			Element solutionElement = doc.createElement(SOLUTION_TAG_NAME);
			rootElement.appendChild(solutionElement);

			for (House house : solution.getHouses()) {
				Element houseElement = doc.createElement(HOUSE_TAG_NAME);
				for (String key : house.getProperties().keySet()) {
					houseElement.setAttribute(key, house.getProperties().get(key));
				}
				solutionElement.appendChild(houseElement);
			}

		}
		return doc;
	}

	private Transformer createTransformer() throws TransformerConfigurationException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource("style.xsl"));
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		return transformer;
	}
}
