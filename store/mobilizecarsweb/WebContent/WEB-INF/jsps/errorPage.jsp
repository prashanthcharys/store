<%@ page isErrorPage="true" %>

<html>
  <body>
    <!-- This displays the fully-qualified name of the exception
         and its message-->
    <%= exception.toString() %>
    <br>

    <!-- This displays the exception's descriptive message -->
    <%= exception.getMessage() %>
  </body>
</html>