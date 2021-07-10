<?php declare(strict_types=1);

declare(strict_types = 1);
namespace SillycatAPI;

require __DIR__ . '/../vendor/autoload.php';

use Nyholm\Psr7\Response;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;
use Psr\Http\Server\RequestHandlerInterface;

class GetArticleHandler implements RequestHandlerInterface
{

    public function handle(ServerRequestInterface $request): ResponseInterface
    {
        $id = $request->getAttribute('id');
        $name = $request->getQueryParams()['name'] ?? 'world';
        $articleService = new ArticleService();
        $response = $articleService->sayHello($name);
        return new Response(200, [], "$response and id $id");
    }
}

return new GetArticleHandler();

