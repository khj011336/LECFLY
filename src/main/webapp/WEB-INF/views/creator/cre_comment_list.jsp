<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src = "resources/js/creator/select.js"></script>
<script>
var lt = new selectList("#offset", ${maxPage} ,"#CRcontent","get",'creator_comment_List.LF');
lt.List();
</script>
  <div id ="CreComWrapb">
            <div id="CRcontent">
                <div id="CRhead"><span class="CRHT">클래스 댓글관리</span> </div>
          
                 <%@include file="_cre_comment.jsp" %>
                 
            </div>
            </div>