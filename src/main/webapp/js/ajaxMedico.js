var xmlHttp;

function getMedicos() {
	var medico = document.getElementById("medico");
	var especialidade = medico.value;

	if (typeof XMLHttpRequest !== "undefined") {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	if (xmlHttp === null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}

	var url = "buscaPorEspecialidade";
	url += "?term=" + especialidade;
	xmlHttp.onreadystatechange = atualizaTabelaMedicos;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);

}

function atualizaTabelaMedicos() {
	if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {

		var medicos = JSON.parse(xmlHttp.responseText);

		// CRIA UMA TABELA DINAMICA

		var table = document.createElement("table");
		table.border = "1";
		table.style.border = "1px solid black";
		table.style.width = "400px";

		// CRIA LINHA TABELA (LINHA CABECALHO).

		var tr = table.insertRow(-1);

		// CRIA COLUNA NA LINHA DE CABECALHO
		var thNome = document.createElement('th');
		thNome.innerHTML = 'Nome';
		thNome.style.width = "70%";
		tr.appendChild(thNome);

		// CRIA COLUNA NA LINHA DE CABECALHO
		var thEspecialidade = document.createElement('th');
		thEspecialidade.innerHTML = 'Especialidade';
		thEspecialidade.style.width = "40%";
		tr.appendChild(thEspecialidade);

		// CRIA DEMAIS LINHAS COM OS VALORES

		for (var i = 0; i < medicos.length; i++) {

			// CRIA NOVA LINHA
			tr = table.insertRow(-1);

			
			var tmp = medicos[i];
			var indice = tmp.indexOf("/");
			var medico = tmp.slice(0, indice);
			var especialidade = tmp.slice(indice + 1);

			// CRIA COLUNA 1 NA LINHA

			var col1 = tr.insertCell(-1);
			col1.innerHTML = medico ;

			// CRIA COLUNA 2 NA LINHA

			var col2 = tr.insertCell(-1);
			// col3.style = "text-align:center"; analogo ao comando abaixo
			col2.style.textAlign = "center";
			col2.innerHTML = especialidade;
			
		
		}

		var divContainer = document.getElementById("medicos");
		divContainer.innerHTML = "";

		// CRIA UM PARAGRAFO (TAG P) COM A QUANTIDADE DE CIDADES

		var p = document.createElement('p');
		p.innerHTML = 'Quantidade: ' + medicos.length;

		// ADICIONA O PARAGRAFO AO CONTAINER.
		divContainer.appendChild(p);

		// ADICIONA A NOVA TABELA AO CONTAINER.
		divContainer.appendChild(table);
	}
}
