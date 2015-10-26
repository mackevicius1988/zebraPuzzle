<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="http://xml.apache.org/xslt/java"
	exclude-result-prefixes="java">

	<xsl:template match="/">
		<html>
			<body>
				<h2>Zebra puzze:
					<xsl:value-of select="java:format(java:java.text.SimpleDateFormat.new('yyyy-MM-dd HH:mm:ss'), java:java.util.Date.new())" />
				</h2>
				<table style=" border-collapse: collapse;">
					<xsl:for-each select="solutions/solution/house">

						<tr>
							<td style="border: 1px solid black; padding:5px">
								<xsl:value-of select="@position" />
							</td>
							<xsl:for-each select="@*">
								<xsl:if test="name() != 'position'">
									<td style="border: 1px solid black; padding:5px">
										<xsl:value-of select="." />
									</td>
								</xsl:if>
							</xsl:for-each>
						</tr>

					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>