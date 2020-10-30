<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Schedule</h2>
    <table border="1">
      <tr bgcolor="#d8d8d8">
        <th>Title</th>
        <th>Professor</th>
		<th>Day</th>
      </tr>
      <xsl:for-each select="Schedule/Lesson/Lecture">
	  <xsl:sort select="string-length(substring-before('MondayTuesdayWednesdayThursdayFridaySatSun', translate(Day, '0123456789', '')))" data-type="number"/>
      <xsl:sort select="translate(Day, translate(Day, '0123456789', ''), '')" data-type="number"/>
	  
	  <xsl:if test="Day = 'Monday'">
      <tr bgcolor="#d83a1e">
        <td><xsl:value-of select="../Title"/></td>
        <td><xsl:value-of select="../Professor"/></td>
		<td><xsl:value-of select="Day"/></td>
      </tr>
	  </xsl:if>
	  <xsl:if test="Day = 'Wednesday'">
      <tr bgcolor="#0a93f0">
        <td><xsl:value-of select="../Title"/></td>
        <td><xsl:value-of select="../Professor"/></td>
		<td><xsl:value-of select="Day"/></td>
      </tr>
	  </xsl:if>
	  <xsl:if test="Day = 'Thursday'">
      <tr bgcolor="#e3db43">
        <td><xsl:value-of select="../Title"/></td>
        <td><xsl:value-of select="../Professor"/></td>
		<td><xsl:value-of select="Day"/></td>
      </tr>
	  </xsl:if>
	  <xsl:if test="Day = 'Friday'">
      <tr bgcolor="#e201e6">
        <td><xsl:value-of select="../Title"/></td>
        <td><xsl:value-of select="../Professor"/></td>
		<td><xsl:value-of select="Day"/></td>
      </tr>
	  </xsl:if>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>