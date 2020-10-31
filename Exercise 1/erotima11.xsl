<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl= "http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
<html>
<head><title>Schedule</title></head>

<body>
<h1>Schedule</h1>
<table border="4">
  <tr bgcolor="#d8d8d8">
    <td>Title</td>
    <td>Professor</td>
    <td>Day</td>
  </tr>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Monday']">
  <tr bgcolor="#B80000">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Tuesday']">
  <tr bgcolor="#00CC07">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Wednesday']">
  <tr bgcolor="#0a93f0">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Thursday']">
  <tr bgcolor="#CCCC00">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Friday']">
  <tr bgcolor="#993399">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Saturday']">
  <tr bgcolor="#db7d12">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
  <xsl:for-each select="//Schedule/Lesson/Lecture[Day='Sunday']">
  <tr bgcolor="#05e7f7">
    <td><xsl:value-of select="../Title"/></td>
    <td><xsl:value-of select="../Professor"/></td>
    <td><xsl:value-of select="Day"/></td>
  </tr>
  </xsl:for-each>
  
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
