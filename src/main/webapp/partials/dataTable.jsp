<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"></script>
    
    <script>
        $(document).ready(function() {
            $('#dataTable').DataTable({
            "ordering": false,
            language: { url: "https://cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json" }
            
        	});
            } );
    </script>
